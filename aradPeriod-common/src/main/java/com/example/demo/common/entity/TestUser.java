package com.example.demo.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chen
 * @since 2020-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TestUser extends Model<TestUser> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 次数
	 */
	private Integer num;
	// 用户编码
	private String userCode;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
