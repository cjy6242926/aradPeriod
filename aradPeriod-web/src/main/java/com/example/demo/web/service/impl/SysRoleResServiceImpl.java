package com.example.demo.web.service.impl;

import com.example.demo.web.entity.Node;
import com.example.demo.web.entity.SysMenu;
import com.example.demo.web.entity.SysRoleRes;
import com.example.demo.web.mapper.SysRoleResMapper;
import com.example.demo.web.service.SysRoleResService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色资源表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Service
public class SysRoleResServiceImpl extends ServiceImpl<SysRoleResMapper, SysRoleRes> implements SysRoleResService {
	@Autowired
	private SysRoleResMapper mapper;

	@Override
	public Integer insertSysRoleRes(SysRoleRes sysRoleRes) {
		return mapper.insert(sysRoleRes);
	}

	@Override
	public void deleteSysRoleRes(Integer id) {
		mapper.deleteById(id);
	}

	@Override
	public SysRoleRes querySysRoleResById(Integer id) {
		return mapper.selectById(id);
	}

	@Override
	public List<SysRoleRes> listSysRoleRess(SysRoleRes sysRoleRes) {
		QueryWrapper<SysRoleRes> wrapper = new QueryWrapper<SysRoleRes>();
		wrapper.eq("role_id", sysRoleRes.getRoleId());
		wrapper.eq("res_id", sysRoleRes.getResId());
		return mapper.selectList(wrapper);
	}

	@Override
	public void deleteSysRoleResByModel(SysRoleRes sysRoleRes) {
		mapper.deleteSysRoleResByModel(sysRoleRes);
	}

	@Override
	public void insertSysRoleRes(List<SysRoleRes> list) {
		mapper.insertSysRoleRes(list);
	}

	@Override
	public SysMenu queryMenu() {
		List<Node> nodes = mapper.queryMenu();
		return new SysMenu(nodes);
	}

	@Override
	public List<Object> queryResIdList(Integer roleId) {
		return mapper.queryResIdList(roleId);
	}

}
