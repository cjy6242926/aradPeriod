package com.example.demo.web.entity;

import java.util.List;

/**
 * 
 * @ClassName: Node
 * @Description: 菜单节点类
 * @author chenjy
 * @date 2020年6月4日 上午11:25:45
 *
 */
public class Node implements Comparable<Node> {
	private Integer menuId;// 菜单id
	private String menuName;// 菜单名称
	private Integer menuLevel;// 菜单等级
	private Integer leafFlagId;// 末级菜单标识
	private Integer moduleId;// 所属模块
	private String menuValue;// 菜单URL
	private String pMenuId;// 上级菜单ID
	private Integer menuSort;
	private String menuIcon; // 菜单图标
	private String leaf;
	private String name;// 菜单名称
	private List<Node> children;// 子节点集合
	private Integer parentId;// 下级菜单对应上级菜单ID
	private Integer id;// 菜单id
	private String link;// 菜单连接指向
	private Integer level;// 菜单层级
	private boolean leafFlag = true;// 叶子节点标识
	private Node parentNode;// 父级节点
	private Integer pId;// 父级菜单编码
	private Integer resId;// 资源id
	private Integer sortId;// 排序字段
	private String menuCode;// 编码
	/**
	 * 模块名称
	 */
	private String moduleName;
	/**
	 * 菜单名称
	 */
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getLeaf() {
		return leaf;
	}

	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	public Integer getLeafFlagId() {
		return leafFlagId;
	}

	public void setLeafFlagId(Integer leafFlagId) {
		this.leafFlagId = leafFlagId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getpMenuId() {
		return pMenuId;
	}

	public void setpMenuId(String pMenuId) {
		this.pMenuId = pMenuId;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getMenuValue() {
		return menuValue;
	}

	public void setMenuValue(String menuValue) {
		this.menuValue = menuValue;
	}

	public Integer getSortId() {
		return sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public boolean isLeafFlag() {
		return leafFlag;
	}

	public void setLeafFlag(boolean leafFlag) {
		this.leafFlag = leafFlag;
	}

	public Node getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	/**
	 * 重写equals，定位id与parentId区分节点
	 */
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Node) {
			Node bo = (Node) obj;
			return this.getId().equals(bo.getId()) && this.getParentId().equals(bo.getId());
		}
		return super.equals(obj);
	}

	/**
	 * 重写hashCode值
	 */
	public int hashCode() {
		return this.getId().hashCode() + (this.getParentId() == null ? 0 : 29 * this.getParentId().hashCode());
	}

	public Integer getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(Integer menuSort) {
		this.menuSort = menuSort;
	}

	@Override
	public String toString() {
		return "Node [menuId=" + menuId + ", menuName=" + menuName + ", menuLevel=" + menuLevel + ", leafFlagId=" + leafFlagId + ", moduleId=" + moduleId + ", menuValue=" + menuValue + ", pMenuId=" + pMenuId + ", menuSort=" + menuSort
				+ ", menuIcon=" + menuIcon + ", leaf=" + leaf + ", name=" + name + ", children=" + children + ", parentId=" + parentId + ", id=" + id + ", link=" + link + ", level=" + level + ", leafFlag=" + leafFlag + ", parentNode="
				+ parentNode + ", pId=" + pId + ", resId=" + resId + ", sortId=" + sortId + ", menuCode=" + menuCode + ", moduleName=" + moduleName + ", title=" + title + "]";
	}

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	@Override
	public int compareTo(Node o) {// 重写排序方法
		// TODO Auto-generated method stub
		return this.getMenuSort().compareTo(o.getMenuSort());
	}

}
