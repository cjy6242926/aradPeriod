package com.example.demo.web.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.util.JsonMessageUtil;
import com.example.demo.web.entity.SysMenu;
import com.example.demo.web.entity.SysRoleRes;
import com.example.demo.web.service.SysRoleResService;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 角色资源表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Slf4j
@Controller
@RequestMapping("/sys-role-res")
public class SysRoleResController {
	@Autowired
	private SysRoleResService service;

	@RequestMapping("/insertSysRoleRes")
	@ResponseBody
	public Map<String, Object> insertSysRoleRes(SysRoleRes sysRoleRes) {
		try {
			service.insertSysRoleRes(sysRoleRes);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/deleteSysRoleRes")
	@ResponseBody
	public Map<String, Object> deleteSysRoleRes(Integer id) {
		try {
			service.deleteSysRoleRes(id);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/deleteSysRoleResByModel")
	@ResponseBody
	public Map<String, Object> deleteSysRoleResByModel(SysRoleRes sysRoleRes) {
		try {
			service.deleteSysRoleResByModel(sysRoleRes);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/querySysRoleResById")
	@ResponseBody
	public Map<String, Object> querySysRoleResById(Integer id) {
		try {
			SysRoleRes sysRoleRes = service.querySysRoleResById(id);
			return JsonMessageUtil.newMsg().push("result", "01").push("data", sysRoleRes).end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/listSysRoleRess")
	@ResponseBody
	public Map<String, Object> listSysRoleRess(SysRoleRes sysRoleRes) {
		try {
			List<SysRoleRes> list = service.listSysRoleRess(sysRoleRes);
			return JsonMessageUtil.newMsg().push("result", "01").push("data", list).end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	/**
	 * 编辑角色资源
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/changeRoleRes")
	@ResponseBody
	public Map<String, Object> changeRoleRes(Integer roleId, String resIds) throws Exception {
		try {
			// 删除旧资源
			SysRoleRes model = new SysRoleRes();
			model.setRoleId(roleId);
			service.deleteSysRoleResByModel(model);
			if ("".equals(resIds)) {
			} else {
				// 添加新资源
				String[] list = resIds.split(",");
				List<SysRoleRes> roleResList = new ArrayList<SysRoleRes>();
				for (int i = 0; i < list.length; i++) {
					SysRoleRes temp = new SysRoleRes();
					temp.setRoleId(roleId);
					temp.setResId(Integer.valueOf(list[i]));
					roleResList.add(temp);
				}
				service.insertSysRoleRes(roleResList);
			}
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	/**
	 * 
	 * @Description:查询菜单资源
	 * @param resType
	 * @param roleId
	 * @return
	 *
	 */
	@RequestMapping("/queryMenu")
	@ResponseBody
	public Map<String, Object> queryMenu(String resType, Integer roleId) {
		System.out.println("查询菜单资源");
		// 查询所有菜单节点信息
		SysMenu menu = service.queryMenu();
		// 查询指定角色拥有菜单节点信息
		List<Object> resIdList = service.queryResIdList(roleId);
		return menu.buildMenuTree(resIdList);
	}

	/**
	 * 
	 * @Description:查询非菜单资源
	 * @param resType
	 * @param roleId
	 * @return
	 *
	 */
	@RequestMapping("/queryNoneMenuResources")
	@ResponseBody
	public Map<String, Object> queryNoneMenuResources(String resType, Integer roleId) {
		try {

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

}
