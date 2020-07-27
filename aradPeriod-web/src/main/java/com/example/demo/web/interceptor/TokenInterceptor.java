package com.example.demo.web.interceptor;

import java.security.SignatureException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.demo.web.config.auth.JwtConfig;

import io.jsonwebtoken.Claims;

/**
 * 
 * @ClassName: TokenInterceptor
 * @Description: token拦截器
 * @author chenjy
 * @date 2020年5月29日 下午6:10:22
 *
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
	@Resource
	private JwtConfig jwtConfig;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws SignatureException {

		// 地址过滤
		String uri = request.getRequestURI();
		//System.out.println("打印uri：" + uri);
		if (uri.contains("/open")) {
			return true;
		}
		//System.out.println("swagger文件放行");
//		if (uri.contains("swagger") || "/aradPeriod-web/".equals(uri) || "/aradPeriod-web/csrf".equals(uri)) {
//			return true;
//		}
		if (uri.contains("swagger")) {
			return true;
		}
		// 验证头部文件是否带有token
		String token = request.getHeader(jwtConfig.getHeader());
		if (!StringUtils.isEmpty(token)) {
			// log.info("请求头中token不为空");
			token = request.getParameter(jwtConfig.getHeader());
		} else {
			throw new SignatureException(jwtConfig.getHeader() + "请求头必备,不能为空");
		}
		// 验证参数是否带有token
		if (StringUtils.isEmpty(token)) {
			throw new SignatureException(jwtConfig.getHeader() + "参数必备,不能为空");
		}
		// log.info("参数中token不为空");
		Claims claims = null;
		try {
			claims = jwtConfig.getTokenClaim(token);
			if (claims == null || jwtConfig.isTokenExpired(claims.getExpiration())) {
				throw new SignatureException(jwtConfig.getHeader() + "失效，请重新登陆");
			}
		} catch (Exception e) {
			throw new SignatureException(jwtConfig.getHeader() + "失效，请重新登录。");
		}
		// 设置用户身份id
		request.setAttribute("identityId", claims.getSubject());
		return true;
	}
}
