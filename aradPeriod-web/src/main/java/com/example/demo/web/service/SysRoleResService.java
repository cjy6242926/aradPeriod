package com.example.demo.web.service;

import com.example.demo.web.entity.SysMenu;
import com.example.demo.web.entity.SysRoleRes;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色资源表 服务类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
public interface SysRoleResService extends IService<SysRoleRes> {

	/**
	 * 
	 * @Description:添加角色资源
	 * @param sysRoleRes
	 * @return
	 *
	 */
	public Integer insertSysRoleRes(SysRoleRes sysRoleRes);

	/**
	 * 
	 * @Description:根据id删除角色资源
	 * @param id
	 *
	 */
	public void deleteSysRoleRes(Integer id);

	/**
	 * 
	 * @Description:根据角色id删除角色资源
	 * @param id
	 *
	 */
	public void deleteSysRoleResByModel(SysRoleRes sysRoleRes);

	/**
	 * 
	 * @Description:根据id查询角色资源
	 * @param id
	 * @return
	 *
	 */
	public SysRoleRes querySysRoleResById(Integer id);

	/**
	 * 
	 * @Description:查询角色资源信息
	 * @param sysRoleRes
	 * @return
	 *
	 */
	public List<SysRoleRes> listSysRoleRess(SysRoleRes sysRoleRes);
	
	/**
	 * 批量添加角色资源
	 * 
	 * @param list
	 */
	public void insertSysRoleRes(List<SysRoleRes> list);
	
	/**
	 * 
	 * @Description:查询所有菜单信息
	 * @return
	 *
	 */
	public SysMenu queryMenu();
	
	public List<Object> queryResIdList(Integer roleId);
}
