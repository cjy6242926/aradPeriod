package com.example.demo.web.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.common.util.JsonMessageUtil;
import com.example.demo.web.entity.SysModule;
import com.example.demo.web.service.SysModuleService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 功能模块表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Slf4j
@Controller
@RequestMapping("/sys-module")
public class SysModuleController {
	@Autowired
	private SysModuleService sysModuleService;

	@RequestMapping(value = "/listModels", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listModules(Integer page, Integer rows, SysModule query) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			IPage<SysModule> list = sysModuleService.querySysModule(page, rows, query);
			map.put("data", list.getRecords());
			map.put("code", 0);
			map.put("count", list.getTotal());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return map;
	}

	/**
	 * 
	 * @Description:添加模块
	 * @param module
	 * @return
	 *
	 */
	@RequestMapping(value = "/insertModule", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertModule(SysModule module) {
		try {
			sysModuleService.insertSysModule(module);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	/**
	 * 
	 * @Description:删除模块
	 * @param module
	 * @return
	 *
	 */
	@RequestMapping(value = "/delModule", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delModule(Integer id) {
		try {
			sysModuleService.deleteSysModule(id);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	/**
	 * 
	 * @Description:根据id查询模块信息
	 * @param module
	 * @return
	 *
	 */
	@RequestMapping(value = "/selModuleById", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selModuleById(Integer id) {
		try {
			SysModule module = sysModuleService.querySysModuleById(id);
			return JsonMessageUtil.newMsg().push("result", "01").push("data", module).end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	/**
	 * 
	 * @Description:更新模块信息
	 * @param module
	 * @return
	 *
	 */
	@RequestMapping(value = "/updateModule", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateModule(SysModule module) {
		try {
			sysModuleService.updateSysModule(module);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	/**
	 * 
	 * @Description:查询所有模块信息
	 * @param module
	 * @return
	 *
	 */
	@RequestMapping(value = "/listModelIdAndName", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> listModelIdAndName(SysModule module) {
		try {
			List<SysModule> list = sysModuleService.listSysModules(module);
			return JsonMessageUtil.newMsg().push("result", "01").push("data", list).end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}
}
