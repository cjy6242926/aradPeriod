package com.example.demo.web.mapper;

import com.example.demo.web.entity.SysModule;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 功能模块表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2020-06-04
 */
public interface SysModuleMapper extends BaseMapper<SysModule> {
	/**
	 * 
	 * @Description:查询模块集合
	 * @param module
	 * @return
	 *
	 */
	public IPage<SysModule> listModels(Page<SysModule> page, @Param("query") SysModule query);
}
