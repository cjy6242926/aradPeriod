package com.example.demo.web.service.impl;

import com.example.demo.web.entity.SysResource;
import com.example.demo.web.mapper.SysResourceMapper;
import com.example.demo.web.service.SysResourceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements SysResourceService {
	@Autowired
	private SysResourceMapper sysResourceMapper;

	@Override
	public IPage<SysResource> listResources(Integer page, Integer rows, SysResource query) {
		Page<SysResource> pageTpl = new Page<SysResource>(page, rows);
		return sysResourceMapper.listResources(pageTpl, query);
	}

	@Override
	public Integer insertSysResource(SysResource sysResource) {
		return sysResourceMapper.insert(sysResource);
	}

	@Override
	public void delSysResource(Integer id) {
		QueryWrapper<SysResource> wrapper = new QueryWrapper<SysResource>();
		wrapper.eq("res_id", id);
		sysResourceMapper.delete(wrapper);
	}

	@Override
	public void updateSysResource(SysResource sysResource) {
		sysResourceMapper.updateById(sysResource);
	}

	@Override
	public SysResource querySysResourceById(Integer id) {
		return sysResourceMapper.querySysResourceById(id);
	}

}
