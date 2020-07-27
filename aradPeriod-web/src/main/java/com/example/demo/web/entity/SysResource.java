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
 * 资源表
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysResource extends Model<SysResource> {

	private static final long serialVersionUID = 1L;

	/**
	 * 资源ID
	 */
	@TableId(value = "res_id", type = IdType.AUTO)
	private Integer resId;

	/**
	 * 资源名称
	 */
	private String resName;

	/**
	 * 菜单资源
	 */
	private String resType;

	/**
	 * 比如url值
	 */
	private String resValue;

	/**
	 * 所属功能模块编码
	 */
	private Integer moduleId;
	/**
	 * 所属模块名称
	 */
	@TableField(exist = false)
	private String moduleName;

	@Override
	protected Serializable pkVal() {
		return this.resId;
	}

}
