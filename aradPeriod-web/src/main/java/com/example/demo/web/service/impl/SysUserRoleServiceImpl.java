package com.example.demo.web.service.impl;

import com.example.demo.web.entity.SysUserRole;
import com.example.demo.web.mapper.SysUserRoleMapper;
import com.example.demo.web.service.SysUserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	@Override
	public void deleteSysUserRole(SysUserRole entity) {
		QueryWrapper<SysUserRole> wrapper = new QueryWrapper<SysUserRole>();
		wrapper.eq("user_id", entity.getUserId());
		sysUserRoleMapper.delete(wrapper);
	}

	@Override
	public void insertSysUserRole(SysUserRole entity) {
		sysUserRoleMapper.insert(entity);
	}

}
