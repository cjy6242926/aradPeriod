package com.example.demo.web.entity;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenu extends Model<SysMenu> {

	private static final long serialVersionUID = 1L;

	/**
	 * 菜单表id
	 */
	@TableId(value = "menu_id", type = IdType.AUTO)
	private Integer menuId;

	/**
	 * 菜单名称
	 */
	private String menuName;

	/**
	 * 菜单层级
	 */
	private Integer menuLevel;

	/**
	 * 末级菜单标识
	 */
	private Integer leafFlag;

	/**
	 * 所属模块
	 */
	private Integer moduleId;

	/**
	 * 菜单值
	 */
	private String menuValue;

	/**
	 * 上级菜单ID
	 */
	private Integer pMenuId;

	/**
	 * 排序字段
	 */
	private Integer menuSort;

	/**
	 * 菜单图标
	 */
	private String menuIcon;

	@Override
	protected Serializable pkVal() {
		return this.menuId;
	}

	@TableField(exist = false)
	private StringBuffer html = new StringBuffer();// 输入html
	@TableField(exist = false)
	private List<Node> nodes;// 菜单对应的所有节点
	@TableField(exist = false)
	private Map<Integer, Node> activeNodes;// 所有激活的节点

	public SysMenu(List<Node> nodes) {
		setNodes(nodes);
	}

	public SysMenu buildNewMenu(List<Node> leafNodes) {
		return new SysMenu(getNeedNodes(leafNodes));
	}

	/**
	 * 
	 * @Description:创建菜单树
	 * @return
	 *
	 */
	public Map<String, Object> buildNewTree() {
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Node node : nodes) {// 遍历所有节点
			if (node.getParentId() == 0) {// 此节点为一级节点
				List<Node> children = getChildren(node);// 获取子节点
				node.setChildren(children);
				if (node.getChildren().isEmpty()) {// 构建叶子节点
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("link", node.getLink());
					map.put("title", node.getName());
					map.put("icon", node.getMenuIcon());
					map.put("jump", node.getLink());
					list.add(map);
				} else {
					list.add(buildSubMenu(node));
				}
			}
		}
		resMap.put("code", 0);
		resMap.put("data", list);
		System.out.println("resMap：" + resMap);
		return resMap;
	}

	/**
	 * 
	 * @Description:获取一级节点和二级节点
	 * @param leafNodes
	 * @return
	 *
	 */
	public List<Node> getNeedNodes(List<Node> leafNodes) {
		// 待返回节点list集合（有序）
		List<Node> listNodes = new ArrayList<Node>();
		// 节点set集合（不重复）包含可见节点及所有父节点
		Set<Node> nodes = new HashSet<Node>();
		// 按父节点构建map 用来排序
		Map<Integer, List<Node>> map = new HashMap<Integer, List<Node>>();
		// 兄弟节点list
		List<Node> midNodes = new ArrayList<Node>();
		// 父节点list
		List<Node> nullNodes = new ArrayList<Node>();
		// 将所有可见节点及其上级放入set集合
		for (Node node : leafNodes) {
			nodes.add(node);
			addParentBo(node, nodes);
		}
		//遍历set集合，将第一级，第二级分开放入list集合中
		for (Node node : nodes) {
			if (node.getParentId() != 0) {
				// 查询该节点同级节点是否已存在
				if (map.get(node.getParentId()) == null) {
					// 不存在
					List<Node> nodeList = new ArrayList<Node>();
					nodeList.add(node);
					map.put(node.getParentId(), nodeList);
				} else {
					// 存在
					map.get(node.getParentId()).add(node);
				}
			} else {
				// 父节点集合
				nullNodes.add(node);
			}
		}
		for (Map.Entry<Integer, List<Node>> entry : map.entrySet()) {
			midNodes = entry.getValue();
			// 兄弟节点排序
			Collections.sort(midNodes);
			// 将二级节点放入节点集合中
			listNodes.addAll(midNodes);
		}
		// 父节点排序
		Collections.sort(nullNodes);
		// 将一级节点放入节点集合中
		listNodes.addAll(nullNodes);
		return listNodes;
	}

	/**
	 * 
	 * @Description:将node的父节点添加到集合中，递归找到最上一级
	 * @param node
	 * @param contains
	 *
	 */
	private void addParentBo(Node node, Set<Node> contains) {
		if (node.getParentId() != 0) {
			for (Node bo : nodes) {
				if (bo.getId().equals(node.getParentId())) {
					contains.add(bo);
					addParentBo(bo, contains);
				}
			}
		}
	}

	/**
	 * 
	 * @Description:获取子菜单集合
	 * @param node
	 * @return
	 *
	 */
	private List<Node> getChildren(Node node) {
		List<Node> children = new ArrayList<Node>();
		Integer id = node.getId();// 获取此节点id
		for (Node child : nodes) {// 遍历节点集合
			if (id.equals(child.getParentId())) {// 判断节点集合中是否包含父节点
				child.setParentNode(node);// 构建父级节点指针
				children.add(child);
			}
		}
		return children;
	}

	/**
	 * 
	 * @Description:构建菜单树
	 * @param node
	 * @return
	 *
	 */
	private Map<String, Object> buildSubMenu(Node node) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Node> children = node.getChildren();
		if (children == null) {
			children = getChildren(node);
			node.setChildren(children);
		}
		if (!children.isEmpty()) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (Node child : children) {
				Map<String, Object> map = new HashMap<String, Object>();
				if (!child.isLeafFlag()) {// 如果不为叶子节点
					if (!StringUtils.isEmpty(child.getMenuIcon())) {
						map.put("icon", child.getMenuIcon());
					}
					map.put("title", child.getName());
					//仅支持两级
					map.put("list", buildSubMenu(child));
					//buildSubMenu(child);
				} else {// 如果为叶子节点
					map.put("jump", child.getLink());
					if (!StringUtils.isEmpty(child.getMenuIcon())) {
						map.put("icon", child.getMenuIcon());
					}
					map.put("title", child.getName());
				}
				list.add(map);
			}
			returnMap.put("list", list);
			returnMap.put("title", node.getName());
			returnMap.put("icon", node.getMenuIcon());
		}
		return returnMap;
	}

	public SysMenu() {
		super();
	}

	/**
	 * 
	 * @Description:构建角色资源树
	 * @param resIdList
	 * @return
	 *
	 */
	public Map<String, Object> buildMenuTree(List<Object> resIdList) {
		Map<String, Object> resMap = new HashMap<>();
		List<Map<String, Object>> list = new ArrayList<>();// 节点是否可见集合
		// 遍历所有节点
		for (Node node : nodes) {
			// 从一级菜单向下找
			if (node.getParentId() == 0) {
				// 若为一级节点
				List<Node> children = getChildren(node);
				node.setChildren(children);
				if (node.getChildren().isEmpty()) {
					// 如果没有子菜单
					Map<String, Object> map = new HashMap<>();
					map.put("title", node.getName());
					map.put("value", node.getResId());
					if (resIdList.contains(node.getResId())) {
						// 如果可见资源id集合中包含该id,说明此节点可见
						map.put("checked", true);
					} else {
						map.put("checked", false);
					}
					list.add(map);
				} else {
					// 如果有子菜单
					list.add(buildSubMenuTree(node, resIdList));
				}
			}
		}
		resMap.put("data", list);
		return resMap;
	}

	/**
	 * 
	 * @Description:构建一级菜单下角色资源树
	 * @param node
	 * @param resIdList
	 * @return
	 *
	 */
	public Map<String, Object> buildSubMenuTree(Node node, List<Object> resIdList) {
		List<Node> children = node.getChildren();
		Map<String, Object> returnMap = new HashMap<>();
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;
		for (Node child : children) {
			if (child.getLeafFlagId() == 0) {
				Map<String, Object> resultMap = buildSubMenuTree(child, resIdList);
				list.add(resultMap);
			} else {
				map = new HashMap<>();
				map.put("title", child.getName());
				map.put("value", child.getResId());
				if (resIdList.contains(child.getResId())) {
					map.put("checked", true);
				} else {
					map.put("checked", false);
				}
				list.add(map);
			}
		}
		returnMap.put("title", node.getName());
		returnMap.put("value", node.getResId());
		returnMap.put("data", list);
		return returnMap;
	}
}
