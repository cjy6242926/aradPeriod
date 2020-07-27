package com.example.demo.web.service;

import com.example.demo.web.entity.SysModule;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 功能模块表 服务类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
public interface SysModuleService extends IService<SysModule> {

	/**
	 * 
	 * @Description:查询模块列表，分页
	 * @param page
	 * @param rows
	 * @param query
	 * @return
	 *
	 */
	public IPage<SysModule> querySysModule(Integer page, Integer rows, SysModule query);

	/**
	 * 
	 * @Description:添加模块
	 * @param module
	 * @return
	 *
	 */
	public Integer insertSysModule(SysModule module);

	/**
	 * 
	 * @Description:根据id删除模块
	 * @param id
	 * @return
	 *
	 */
	public boolean deleteSysModule(Integer id);

	/**
	 * 
	 * @Description:根据id查询模块
	 * @param id
	 * @return
	 *
	 */
	public SysModule querySysModuleById(Integer id);

	/**
	 * 
	 * @Description:更新模块信息
	 * @return
	 *
	 */
	public boolean updateSysModule(SysModule module);

	/**
	 * 
	 * @Description:查询所有模块信息
	 * @param module
	 * @return
	 *
	 */
	public List<SysModule> listSysModules(SysModule module);
}
