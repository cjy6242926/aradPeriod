package com.example.demo.web.mapper;

import com.example.demo.web.entity.SysUser;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
	
	public SysUser querySysUserById(Integer id);

	public IPage<SysUser> iPageSysUser(Page<SysUser> page, @Param("query") SysUser query);
	
	public SysUser querySysUserByNameAndPwd(@Param("query") SysUser query);

}
