package com.example.demo.web.service;

import com.example.demo.web.entity.SysRole;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
public interface SysRoleService extends IService<SysRole> {

	/**
	 * 
	 * @Description:查询角色列表并分页
	 * @param page
	 * @param query
	 * @return
	 *
	 */
	public IPage<SysRole> listSysRoles(Integer page, Integer rows, @Param("query") SysRole query);

	/**
	 * 
	 * @Description:添加角色
	 * @param sysRole
	 * @return
	 *
	 */
	public Integer insertSysRole(SysRole sysRole);

	/**
	 * 
	 * @Description:根据id删除角色
	 * @param id
	 *
	 */
	public void deleteSysRole(Integer id);

	/**
	 * 
	 * @Description:更新角色信息
	 * @param sysRole
	 *
	 */
	public void updateSysRole(SysRole sysRole);

	/**
	 * 
	 * @Description:根据id查询角色信息
	 * @param id
	 * @return
	 *
	 */
	public SysRole querySysRoleById(Integer id);

	/**
	 * 
	 * @Description:查询所有角色信息
	 * @return
	 *
	 */
	public List<SysRole> listRoles();

}
