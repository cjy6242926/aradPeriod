package com.example.demo.web.service.impl;

import com.example.demo.web.entity.SysUser;
import com.example.demo.web.mapper.SysUserMapper;
import com.example.demo.web.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public Integer insertSysUser(SysUser model) {
		return sysUserMapper.insert(model);
	}

	@Override
	public void deleteSysUserById(Integer id) {
		sysUserMapper.deleteById(id);
	}

	@Override
	public void updateSysUserById(SysUser model) {
		sysUserMapper.updateById(model);
	}

	@Override
	public SysUser querySysUserById(Integer id) {
		return sysUserMapper.querySysUserById(id);
	}

	@Override
	public IPage<SysUser> querySysUser(Integer page, Integer rows, SysUser sysUser) {
		Page<SysUser> pageTpl = new Page<SysUser>(page, rows);
		return sysUserMapper.iPageSysUser(pageTpl, sysUser);
	}

	@Override
	public SysUser querySysUserByNameAndPwd(SysUser sysUser) {
		return sysUserMapper.querySysUserByNameAndPwd(sysUser);
	}

}
