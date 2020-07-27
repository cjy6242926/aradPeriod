package com.example.demo.web.mapper;

import com.example.demo.web.entity.SysResource;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {
	/**
	 * 
	 * @Description:查询资源信息并分页
	 * @param page
	 * @param query
	 * @return
	 *
	 */
	public IPage<SysResource> listResources(Page<SysResource> page, @Param("query") SysResource query);
	
	/**
	 * 
	 * @Description:根据id查询资源信息
	 * @param id
	 * @return
	 *
	 */
	public SysResource querySysResourceById(Integer id);
}
