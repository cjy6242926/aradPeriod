package com.example.demo.web.service;

import com.example.demo.web.entity.Node;
import com.example.demo.web.entity.SysMenu;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
public interface SysMenuService extends IService<SysMenu> {
	/**
	 * 
	 * @Description:查询所有菜单资源
	 * @return
	 *
	 */
	public List<Node> queryAllMenuNodes();

	/**
	 * 
	 * @Description:根据用户userId查询用户拥有菜单资源
	 * @param userId
	 * @return
	 *
	 */
	public List<Node> queryUserMenuNodes(Integer userId);

	/**
	 * 
	 * @Description:获取用户菜单
	 * @param userId
	 * @return
	 *
	 */
	public SysMenu queryUserMenu(Integer userId);

	/**
	 * 
	 * @Description:根据上级id查询节点集合
	 * @param node
	 * @return
	 *
	 */
	public List<Node> queryNodeByPid(Node node);
	
	/**
	 * 
	 * @Description:根据menu_id删除菜单信息
	 * @param id
	 * @return  
	 *
	 */
	public Integer deleteMenuByMenuId(Integer id);
	
	/**
	 * 
	 * @Description:添加菜单
	 * @param node
	 * @return 
	 *
	 */
	public Integer insertNode(Node node);
	
	/**
	 * 
	 * @Description:更新菜单信息
	 * @param node
	 *
	 */
	public void updateNode(@Param("node") Node node);
	
	/**
	 * 
	 * @Description:查询菜单名称和值
	 * @return
	 *
	 */
	public List<SysMenu> queryMenuValue();
}
