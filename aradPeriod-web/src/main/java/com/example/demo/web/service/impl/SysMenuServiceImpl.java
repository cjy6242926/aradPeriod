package com.example.demo.web.service.impl;

import com.example.demo.web.entity.Node;
import com.example.demo.web.entity.SysMenu;
import com.example.demo.web.mapper.SysMenuMapper;
import com.example.demo.web.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Override
	public List<Node> queryAllMenuNodes() {
		return sysMenuMapper.queryAllMenuNodes();
	}

	@Override
	public List<Node> queryUserMenuNodes(Integer userId) {
		return sysMenuMapper.queryUserMenuNodes(userId);
	}

	@Override
	public SysMenu queryUserMenu(Integer userId) {
		// 查询所有菜单
		List<Node> allMenuNodes = sysMenuMapper.queryAllMenuNodes();
		// 查询用户菜单
		List<Node> userNodes = sysMenuMapper.queryUserMenuNodes(userId);
		// 构建菜单
		return new SysMenu(allMenuNodes).buildNewMenu(userNodes);
	}

	@Override
	public List<Node> queryNodeByPid(Node node) {
		return sysMenuMapper.queryNodeByPid(node);
	}

	@Override
	public Integer deleteMenuByMenuId(Integer id) {
		QueryWrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>();
		wrapper.eq("menu_id", id);
		return sysMenuMapper.delete(wrapper);
	}

	@Override
	public Integer insertNode(Node node) {
		return sysMenuMapper.insertNode(node);
	}

	@Override
	public void updateNode(Node node) {
		sysMenuMapper.updateNode(node);
	}

	@Override
	public List<SysMenu> queryMenuValue() {
		return sysMenuMapper.queryMenuValue();
	}
}
