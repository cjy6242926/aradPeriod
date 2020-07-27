package com.example.demo.web.service;

import com.example.demo.web.entity.SysResource;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
public interface SysResourceService extends IService<SysResource> {

	/**
	 * 
	 * @Description:查询资源信息并分页
	 * @param page
	 * @param query
	 * @return
	 *
	 */
	public IPage<SysResource> listResources(Integer page, Integer rows, @Param("query") SysResource query);

	/**
	 * 
	 * @Description:添加资源
	 * @param query
	 * @return
	 *
	 */
	public Integer insertSysResource(SysResource sysResource);

	/**
	 * 
	 * @Description:删除资源
	 * @param id
	 *
	 */
	public void delSysResource(Integer id);

	/**
	 * 
	 * @Description:更新资源信息
	 * @param sysResource
	 *
	 */
	public void updateSysResource(SysResource sysResource);

	/**
	 * 
	 * @Description:根据id查询资源信息
	 * @param id
	 * @return
	 *
	 */
	public SysResource querySysResourceById(Integer id);

}
