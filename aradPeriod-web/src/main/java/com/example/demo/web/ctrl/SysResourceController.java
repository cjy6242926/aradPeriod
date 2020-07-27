package com.example.demo.web.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.common.util.JsonMessageUtil;
import com.example.demo.web.entity.SysResource;
import com.example.demo.web.service.SysResourceService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Slf4j
@Controller
@RequestMapping("/sys-resource")
public class SysResourceController {
	@Autowired
	private SysResourceService sysResourceService;

	@RequestMapping("/listResources")
	@ResponseBody
	public Map<String, Object> listResources(Integer page, Integer rows, SysResource sysResource) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IPage<SysResource> iPage = sysResourceService.listResources(page, rows, sysResource);
			map.put("data", iPage.getRecords());
			map.put("code", 0);
			map.put("count", iPage.getTotal());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return map;
	}

	@RequestMapping("/insertSysResource")
	@ResponseBody
	public Map<String, Object> insertSysResource(SysResource sysResource) {
		try {
			sysResourceService.insertSysResource(sysResource);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/delSysResource")
	@ResponseBody
	public Map<String, Object> delSysResource(Integer id) {
		try {
			sysResourceService.delSysResource(id);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/updateSysResource")
	@ResponseBody
	public Map<String, Object> updateSysResource(SysResource sysResource) {
		try {
			sysResourceService.updateSysResource(sysResource);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/querySysResourceById")
	@ResponseBody
	public Map<String, Object> querySysResourceById(Integer id) {
		try {
			SysResource sysResource = sysResourceService.querySysResourceById(id);
			return JsonMessageUtil.newMsg().push("result", "01").push("data", sysResource).end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}
}
