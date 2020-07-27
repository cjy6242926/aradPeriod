package com.example.demo.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 功能模块表
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysModule extends Model<SysModule> {

	private static final long serialVersionUID = 1L;

	/**
	 * 模块ID
	 */
	@TableId(value = "module_id", type = IdType.AUTO)
	private Integer moduleId;

	/**
	 * 模块名称
	 */
	private String moduleName;

	/**
	 * 模块类型（1：系统模块；2：功能模块）
	 */
	private String moduleType;

	@Override
	protected Serializable pkVal() {
		return this.moduleId;
	}

	@TableField(exist = false)
	private String name;
	@TableField(exist = false)
	private String id;
	@TableField(exist = false)
	private Integer pId;// 父级菜单编码
	@TableField(exist = false)
	private Integer level;// 菜单层级
	@TableField(exist = false)
	private boolean leafFlag = true;// 叶子节点标识
	@TableField(exist = false)
	private String link;// 菜单连接指向
//	@TableField(exist = false)
//	private Integer page;
//	@TableField(exist = false)
//	private Integer rows;
}
