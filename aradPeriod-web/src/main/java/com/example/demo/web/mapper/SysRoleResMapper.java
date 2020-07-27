package com.example.demo.web.mapper;

import com.example.demo.web.entity.Node;
import com.example.demo.web.entity.SysRoleRes;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 角色资源表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
public interface SysRoleResMapper extends BaseMapper<SysRoleRes> {

	/**
	 * 
	 * @Description:删除角色资源
	 * @param id
	 *
	 */
	public void deleteSysRoleResByModel(@Param("query") SysRoleRes query);

	/**
	 * 批量添加角色资源
	 * 
	 * @param list
	 */
	public void insertSysRoleRes(@Param("list") List<SysRoleRes> list);

	/**
	 * 
	 * @Description:查询所有菜单信息
	 * @return
	 *
	 */
	public List<Node> queryMenu();
	
	public List<Object> queryResIdList(@Param("roleId")Integer roleId);

}
