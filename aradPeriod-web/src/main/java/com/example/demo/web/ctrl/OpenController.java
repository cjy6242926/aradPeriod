package com.example.demo.web.ctrl;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.config.ProConstant;
import com.example.demo.common.util.VerificationCodeUtil;
import com.example.demo.web.config.auth.JwtConfig;
import com.example.demo.web.entity.SysMenu;
import com.example.demo.web.entity.SysUser;
import com.example.demo.web.service.SysMenuService;
import com.example.demo.web.service.SysUserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName: OpenController
 * @Description: 开放接口
 * @author chenjy
 * @date 2020年5月9日 下午5:32:53
 *
 */
@Slf4j
@RequestMapping("/open")
@Controller
public class OpenController {
	@Autowired
	private JwtConfig JwtConfig;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private SysMenuService sysMenuService;

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 
	 * @Description:登陆接口，登陆后返回token
	 * @param name
	 * @param password
	 * @return
	 *
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "登陆",notes = "登陆接口，返回token")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userName",value = "用户名",required = true,dataType ="String" ),
		@ApiImplicitParam(name = "password",value = "用户密码",required = true,dataType ="String" ),
		@ApiImplicitParam(name = "vercode",value = "验证码",required = true,dataType ="String" )
	})
	public SysUser login(HttpServletRequest request, String userName, String password, String vercode) {
		log.info("userName  :" + userName + "  password  :" + password + " vercode：" + vercode);
		SysUser user = new SysUser();
		// 获取redis中缓存验证码ck
		Cookie[] cookies = request.getCookies();
		String redisVercode = null;
		if (cookies != null) {
			boolean flag = false;
			for (Cookie cookie : cookies) {
				if ("ck".equals(cookie.getName())) {
					redisVercode = (String) redisTemplate.opsForValue().get(cookie.getValue());
					flag = true;
					break;
				}
			}
			if (flag) {
				if (vercode.equals(redisVercode)) {
					// 根据用户名和密码查询用户信息
					SysUser temp = new SysUser();
					temp.setUserName(userName);
					temp.setPassword(password);
					SysUser sysUser = sysUserService.querySysUserByNameAndPwd(temp);
//					if ("system".equals(userName) && "123456".equals(password)) {// 固定登陆账户
//						user.setUserId(6);
//						user.setUserName(userName);
//						user.setPassword(password);// 此处不加密
//					}
					if (sysUser.getUserId() != null) {
						String userId = sysUser.getUserId() + "";
						String access_token = JwtConfig.createToken(userId);
						if (access_token != null) {
							log.info("token  :" + access_token);
							user.setRespCode(ProConstant.RES_CODE_ONE);
							user.setRespMsg("3");
							user.setToken(access_token);
							return user;
						}
					}
				} else {
					user.setRespCode(ProConstant.RES_CODE_TWO);// 验证码错误
					return user;
				}
			}
		}
		user.setRespCode(ProConstant.RES_CODE_THREE);// 系统繁忙
		return user;
	}

	/**
	 * 
	 * @Description:获取验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 *
	 */
	@RequestMapping("/getVerifyCode")
	@ResponseBody
	public void getverufyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String verifyCode = null;
		String verikey = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			boolean flag = true;
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("ck")) {// 不为第一次请求
					if (cookie.getValue() != null) {
						verikey = cookie.getValue();
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				verikey = "c" + System.currentTimeMillis();
				Cookie cookie = new Cookie("ck", verikey);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		} else {// 第一次请求，不带cookie
			verikey = "c" + System.currentTimeMillis();
			Cookie cookie = new Cookie("ck", verikey);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		verifyCode = VerificationCodeUtil.generateVerificationCode(response.getOutputStream(), 83, 36);
		redisTemplate.opsForValue().set(verikey, verifyCode, 15, TimeUnit.SECONDS);
		response.getOutputStream().close();
	}

	/**
	 * 
	 * @Description:查询用户菜单
	 * @param token
	 * @return
	 *
	 */
	@RequestMapping(value = "/getUserMenu", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUserMenu(String token) {
		Map<String, Object> claims = JwtConfig.getTokenClaim(token);
		System.out.println("claims：" + claims);
		String userId = (String) claims.get("sub");
		System.out.println("userId：" + userId);
		SysMenu menu = sysMenuService.queryUserMenu(Integer.parseInt(userId));
		System.out.println("打印用户可见菜单及父级菜单：" + menu);
		return menu.buildNewTree();
	}

}
