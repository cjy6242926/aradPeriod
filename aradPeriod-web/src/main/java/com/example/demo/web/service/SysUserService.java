package com.example.demo.web.service;

import com.example.demo.web.entity.SysUser;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
public interface SysUserService extends IService<SysUser> {

	/**
	 * 
	 * @Description:添加用户
	 * @param model
	 * @return
	 *
	 */
	public Integer insertSysUser(SysUser model);

	/**
	 * 
	 * @Description:根据id删除用户
	 * @param id
	 *
	 */
	public void deleteSysUserById(Integer id);

	/**
	 * 
	 * @Description:根据id更新用户信息
	 * @param model
	 *
	 */
	public void updateSysUserById(SysUser model);

	/**
	 * 
	 * @Description:根据id查询用户信息
	 * @param id
	 *
	 */
	public SysUser querySysUserById(Integer id);

	/**
	 * 
	 * @Description:查询用户集合并分页
	 * @param page
	 * @param rows
	 * @param sysUser
	 * @return
	 *
	 */
	public IPage<SysUser> querySysUser(Integer page, Integer rows, SysUser sysUser);
	
	public SysUser querySysUserByNameAndPwd(SysUser sysUser);

}
