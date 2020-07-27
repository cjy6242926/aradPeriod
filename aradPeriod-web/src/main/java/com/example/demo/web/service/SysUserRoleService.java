package com.example.demo.web.service;

import com.example.demo.web.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户角色表 服务类
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
public interface SysUserRoleService extends IService<SysUserRole> {
	
	public void deleteSysUserRole(SysUserRole entity);
	
	public void insertSysUserRole(SysUserRole entity);

}
