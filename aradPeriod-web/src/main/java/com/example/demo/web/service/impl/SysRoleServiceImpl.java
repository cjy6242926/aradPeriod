package com.example.demo.web.service.impl;

import com.example.demo.web.entity.SysRole;
import com.example.demo.web.mapper.SysRoleMapper;
import com.example.demo.web.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Override
	public IPage<SysRole> listSysRoles(Integer page, Integer rows, SysRole query) {
		Page<SysRole> pageTpl = new Page<SysRole>(page, rows);
		return sysRoleMapper.listSysRoles(pageTpl, query);
	}

	@Override
	public Integer insertSysRole(SysRole sysRole) {
		return sysRoleMapper.insert(sysRole);
	}

	@Override
	public void deleteSysRole(Integer id) {
		sysRoleMapper.deleteById(id);
	}

	@Override
	public void updateSysRole(SysRole sysRole) {
		sysRoleMapper.updateById(sysRole);
	}

	@Override
	public SysRole querySysRoleById(Integer id) {
		return sysRoleMapper.selectById(id);
	}

	@Override
	public List<SysRole> listRoles() {
		return sysRoleMapper.selectList(null);
	}

}
