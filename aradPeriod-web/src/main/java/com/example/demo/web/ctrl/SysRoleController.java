package com.example.demo.web.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.common.util.JsonMessageUtil;
import com.example.demo.web.entity.SysRole;
import com.example.demo.web.service.SysRoleService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Slf4j
@Controller
@RequestMapping("/sys-role")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;

	@RequestMapping("/listSysRoles")
	@ResponseBody
	public Map<String, Object> listSysRoles(Integer page, Integer rows, SysRole query) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IPage<SysRole> iPage = sysRoleService.listSysRoles(page, rows, query);
			map.put("code", 0);
			map.put("data", iPage.getRecords());
			map.put("count", iPage.getTotal());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return map;
	}

	@RequestMapping("/insertSysRole")
	@ResponseBody
	public Map<String, Object> insertSysRole(SysRole sysRole) {
		try {
			sysRoleService.insertSysRole(sysRole);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/deleteSysRole")
	@ResponseBody
	public Map<String, Object> deleteSysRole(Integer id) {
		try {
			sysRoleService.deleteSysRole(id);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/updateSysRole")
	@ResponseBody
	public Map<String, Object> updateSysRole(SysRole sysRole) {
		try {
			sysRoleService.updateById(sysRole);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/querySysRoleById")
	@ResponseBody
	public Map<String, Object> querySysRoleById(Integer id) {
		try {
			SysRole sysRole = sysRoleService.querySysRoleById(id);
			return JsonMessageUtil.newMsg().push("result", "01").push("data", sysRole).end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/listmRoleIdAndName")
	@ResponseBody
	public Map<String, Object> listmRoleIdAndName(SysRole sysRole) {
		try {
			List<SysRole> list = sysRoleService.listRoles();
			return JsonMessageUtil.newMsg().push("result", "01").push("data", list).end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

}
