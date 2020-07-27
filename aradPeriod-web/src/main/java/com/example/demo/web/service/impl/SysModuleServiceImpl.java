package com.example.demo.web.service.impl;

import com.example.demo.web.entity.SysModule;
import com.example.demo.web.mapper.SysModuleMapper;
import com.example.demo.web.service.SysModuleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 功能模块表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Service
public class SysModuleServiceImpl extends ServiceImpl<SysModuleMapper, SysModule> implements SysModuleService {
	@Autowired
	private SysModuleMapper sysModuleMapper;

	@Override
	public IPage<SysModule> querySysModule(Integer page, Integer rows, SysModule query) {
		Page<SysModule> pageTpl = new Page<SysModule>(page, rows);
		return sysModuleMapper.listModels(pageTpl, query);
	}

	@Override
	public Integer insertSysModule(SysModule module) {
		return sysModuleMapper.insert(module);
	}

	@Override
	public boolean deleteSysModule(Integer id) {
		sysModuleMapper.deleteById(id);
		return true;
	}

	@Override
	public SysModule querySysModuleById(Integer id) {
		return sysModuleMapper.selectById(id);
	}

	@Override
	public boolean updateSysModule(SysModule module) {
		sysModuleMapper.updateById(module);
		return true;
	}

	@Override
	public List<SysModule> listSysModules(SysModule module) {
		QueryWrapper<SysModule> wrapper = new QueryWrapper<SysModule>(module);
		return sysModuleMapper.selectList(wrapper);
	}

}
