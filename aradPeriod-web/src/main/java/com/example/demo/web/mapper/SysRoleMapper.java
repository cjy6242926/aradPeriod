package com.example.demo.web.mapper;

import com.example.demo.web.entity.SysRole;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
	/**
	 * 
	 * @Description:查询角色列表并分页
	 * @param page
	 * @param query
	 * @return
	 *
	 */
	public IPage<SysRole> listSysRoles(Page<SysRole> page, @Param("query") SysRole query);
}
