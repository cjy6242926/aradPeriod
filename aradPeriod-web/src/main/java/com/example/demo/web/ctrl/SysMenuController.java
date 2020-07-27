package com.example.demo.web.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.util.JsonMessageUtil;
import com.example.demo.web.entity.Node;
import com.example.demo.web.entity.SysMenu;
import com.example.demo.web.service.SysMenuService;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Slf4j
@Controller
@RequestMapping("/sys-menu")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 
	 * @Description:获取菜单树
	 * @param node
	 * @return
	 *
	 */
	@RequestMapping("/getMenuTree")
	@ResponseBody
	public Map<String, Object> getMenuTree(Node node) {
		List<Node> list = sysMenuService.queryNodeByPid(node);
		Node tempNode = new Node();
		tempNode.setMenuId(0);
		tempNode.setpMenuId("-1");
		tempNode.setParentId(0);
		tempNode.setName("菜单");
		tempNode.setLeafFlagId(0);
		tempNode.setTitle("菜单");
		tempNode.setId(0);
		list.add(tempNode);
		List<Node> menuModels = getLevelData(list, -1);
		if (menuModels.size() > 0) {
			return JsonMessageUtil.newMsg().push("data", menuModels).push("result", "01").end();
		} else {
			return JsonMessageUtil.newMsg().push("data", list).push("result", "01").end();
		}
	}

	/**
	 * 
	 * @Description:递归查询所有节点
	 * @param dbList
	 * @param parentId
	 * @return
	 *
	 */
	public List<Node> getLevelData(List<Node> dbList, Integer parentId) {
		List<Node> resultList = new ArrayList<Node>();
		for (Node data : dbList) {
			if (data.getpMenuId().equals(parentId.toString())) {
				List<Node> childList = getLevelData(dbList, data.getMenuId());
				data.setChildren(childList);
				resultList.add(data);
			}
		}
		return resultList;
	}

	/**
	 * 
	 * @Description:删除菜单
	 * @param menu_id
	 * @return
	 *
	 */
	@RequestMapping("/delNode")
	@ResponseBody
	public Map<String, Object> delNode(Integer id) {
		try {
			sysMenuService.deleteMenuByMenuId(id);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	/**
	 * 
	 * @Description:添加菜单
	 * @param menu_id
	 * @return
	 *
	 */
	@RequestMapping("/insertNode")
	@ResponseBody
	public Map<String, Object> insertNode(Node node) {
		try {
			sysMenuService.insertNode(node);
			return JsonMessageUtil.newMsg().push("result", "01").end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	/**
	 * 
	 * @Description:更新菜单
	 * @param node
	 * @return
	 *
	 */
	@RequestMapping("/updateNode")
	@ResponseBody
	public Map<String, Object> updateNode(Node node) {
		String name1 = node.getMenuName();
		String value1 = node.getMenuValue();
		boolean nameFlag = false;
		boolean valueFlag = false;
		if (name1 != null && !"".equals(name1)) {
			nameFlag = true;
		}
		if (value1 != null && !"".equals(value1)) {
			valueFlag = true;
		}
		if (nameFlag || valueFlag) {
			try {
				sysMenuService.updateNode(node);
				return JsonMessageUtil.newMsg().push("result", "01").end();
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}

	@RequestMapping("/queryMenuValue")
	@ResponseBody
	public Map<String, Object> queryMenuValue() {
		try {
			List<SysMenu> list = sysMenuService.queryMenuValue();
			return JsonMessageUtil.newMsg().push("result", "01").push("data", list).end();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return JsonMessageUtil.newMsg().push("result", "02").end();
	}
}
