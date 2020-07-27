package com.example.demo.web.mapper;

import com.example.demo.web.entity.Node;
import com.example.demo.web.entity.SysMenu;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

	/**
	 * 
	 * @Description:查询所有菜单资源
	 * @return
	 *
	 */
	public List<Node> queryAllMenuNodes();

	/**
	 * 
	 * @Description:查询用户菜单资源
	 * @param userId
	 * @return
	 *
	 */
	public List<Node> queryUserMenuNodes(Integer id);

	/**
	 * 
	 * @Description:根据上级id查询节点信息
	 * @param node
	 * @return
	 *
	 */
	public List<Node> queryNodeByPid(@Param("node") Node node);

	/**
	 * 
	 * @Description:添加菜单
	 * @param node
	 * @return
	 *
	 */
	public Integer insertNode(@Param("node") Node node);

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
