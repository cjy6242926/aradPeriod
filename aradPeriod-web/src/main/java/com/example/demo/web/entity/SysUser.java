package com.example.demo.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.List;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser extends Model<SysUser> {

	private static final long serialVersionUID = 1L;

	/**
	 * 系统用户表id
	 */
	@TableId(value = "user_id", type = IdType.AUTO)
	private Integer userId;

	/**
	 * 登录名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 真实姓名
	 */
	private String userRealName;

	/**
	 * 用户编码
	 */
	private String userCode;

	/**
	 * 院系ID
	 */
	private Integer departId;

	/**
	 * 登录日期
	 */
	private LocalDateTime loginDate;

	/**
	 * 头像
	 */
	private String userPhoto;

	/**
	 * 手机号码
	 */
	private String userPhone;

	/**
	 * qq号码
	 */
	private String userQq;

	/**
	 * email
	 */
	private String userEmail;

	/**
	 * 删除标识
	 */
	private String deleteFlag;

	/**
	 * 系统角色id
	 */
	private Integer roleId;

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

	/** 用户角色集 **/
	@TableField(exist = false)
	private List<SysRole> roles;

	@TableField(exist = false)
	private String respCode; // 响应代码（0成功，1鉴权，2无权访问，3业务处理失败）

	@TableField(exist = false)
	private String respMsg; // 响应提示信息（0未登录，1已登录，2用户名密码错误，3用户名密码正确，4系统发生错误，5token校验失败，6token校验通过，7token已过期，8
							// 验证码错误）

	@TableField(exist = false)
	private String token; // 用户访问所有接口唯一凭据

	/**
	 * 角色名称
	 */
	@TableField(exist = false)
	private String roleName;
}
