package com.example.demo.web.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色资源表
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRoleRes extends Model<SysRoleRes> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 资源ID
     */
    private Integer resId;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
