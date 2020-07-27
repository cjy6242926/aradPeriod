package com.example.demo.web.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.common.util.JsonMessageUtil;
import com.example.demo.web.entity.SysUser;
import com.example.demo.web.entity.SysUserRole;
import com.example.demo.web.service.SysUserRoleService;
import com.example.demo.web.service.SysUserService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Slf4j
@Controller
@RequestMapping("/sys-user")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;

	@RequestMapping("/listUserInfos")
	@ResponseBody
	public Map<String, Object> listUserInfos(Integer page, Integer rows, SysUser sysUser) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IPage<SysUser> iPage = sysUserService.querySysUser(page, rows, sysUser);
			map.put("code", 0);
			map.put("data", iPage.getRecords());
			map.put("count", iPage.getTotal());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return map;
	}

	@RequestMapping("/insertSysUser")
	@ResponseBody
	public Map<String, Object> insertSysUser(SysUser sysUser) {
		try {
			Integer userId = sysUserService.insertSysUser(sysUser);
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setUserId(userId);
			sysUserRole.setRoleId(sysUser.getRoleId());
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/deleteSysUser")
	@ResponseBody
	public Map<String, Object> deleteSysUser(Integer id) {
		try {
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setUserId(id);
			sysUserRoleService.deleteSysUserRole(sysUserRole);
			sysUserService.deleteSysUserById(id);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/updateSysUser")
	@ResponseBody
	public Map<String, Object> updateSysUser(SysUser sysUser) {
		try {
			SysUser user = sysUserService.querySysUserById(sysUser.getUserId());
			// 删除用户原有角色
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setUserId(user.getUserId());
			sysUserRoleService.deleteSysUserRole(sysUserRole);
			// 添加新角色
			SysUserRole temp = new SysUserRole();
			temp.setUserId(user.getUserId());
			temp.setRoleId(sysUser.getRoleId());
			sysUserRoleService.insertSysUserRole(temp);
			sysUserService.updateSysUserById(sysUser);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/querySysUserById")
	@ResponseBody
	public Map<String, Object> querySysUserById(Integer id) {
		try {
			SysUser sysUser = sysUserService.querySysUserById(id);
			return JsonMessageUtil.newMsg().push("result", "01").push("data", sysUser).end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

}
