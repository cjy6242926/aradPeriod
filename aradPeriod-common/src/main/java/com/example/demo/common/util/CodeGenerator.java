package com.example.demo.common.util;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 
 * @ClassName: CodeGenerator
 * @Description: 代码生成
 * @author chenjy
 * @date 2020年3月11日 下午2:50:17
 *
 */
public class CodeGenerator {
	public static void main(String[] args) {
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		// 获得程序当前路径
		String projectPath = System.getProperty("user.dir");
		gc.setOutputDir(projectPath + "/src/main/java");
		// 设置用户名
		gc.setAuthor("chen");
		gc.setOpen(true);
		// service命名方式
		gc.setServiceName("%sService");
		// service impl命名方式
		gc.setServiceImplName("%sServiceImpl");
		// 自定义文件命名，注意%s会自动填充表实体属性
		gc.setMapperName("%sMapper");
		gc.setXmlName("%sMapper");
		gc.setFileOverride(true);
		gc.setActiveRecord(true);
		// xml 二级缓存
		gc.setEnableCache(false);
		// xml ResultMap
		gc.setBaseResultMap(true);
		// xml columList
		gc.setBaseColumnList(false);
		mpg.setGlobalConfig(gc);

		// 配置数据源
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl(
				"jdbc:mysql://127.0.0.1:3306/mysql01?characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true&serverTimezone=UTC");
		dsc.setDriverName("com.mysql.cj.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("123456");
		mpg.setDataSource(dsc);

		// 包设置
		PackageConfig pc = new PackageConfig();
		// pc.setModuleName(scanner("模块名"));
		pc.setParent("com.example.demo.common");//包名
		pc.setController("ctrl");
		pc.setMapper("mapper");
		pc.setEntity("entity");
		pc.setService("service");
		pc.setServiceImpl("service.impl");
		mpg.setPackageInfo(pc);

		// 自定义需要填充的字段
		@SuppressWarnings("unused")
		List<TableFill> tableFillList = new ArrayList<TableFill>();
		// 如 每张表都有一个创建时间、修改时间
		// 而且这基本上就是通用的了，新增时，创建时间和修改时间同时修改
		// 修改时，修改时间会修改，
		// 虽然像Mysql数据库有自动更新几只，但像ORACLE的数据库就没有了，
		// 使用公共字段填充功能，就可以实现，自动按场景更新了。
		// 如下是配置
		// TableFill createField = new TableFill("gmt_create", FieldFill.INSERT);
		// TableFill modifiedField = new TableFill("gmt_modified",
		// FieldFill.INSERT_UPDATE);
		// tableFillList.add(createField);
		// tableFillList.add(modifiedField);

		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {

			@Override
			public void initMap() {
				// TODO Auto-generated method stub
			}
		};
		List<FileOutConfig> foList = new ArrayList<FileOutConfig>();
		foList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输入文件名称
				return projectPath + "/src/main/resources/mapper/" + "/" + tableInfo.getEntityName() + "Mapper"
						+ StringPool.DOT_XML;
			}
		});
		cfg.setFileOutConfigList(foList);
		mpg.setCfg(cfg);
		mpg.setTemplate(new TemplateConfig().setXml(null));

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		// strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
		strategy.setEntityLombokModel(true);
		// strategy.setRestControllerStyle(true);
		// 公共父类
		// strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
		//写与父类中的公共字段
		//strategy.setSuperEntityColumns("id");
		// 设置逻辑删除键
		//strategy.setLogicDeleteFieldName("deleted");//表中无此字段无需设置
		//strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
		strategy.setInclude("user");//要操作的表
		//strategy.setTablePrefix(pc.getModuleName() + "_");
		// 驼峰转连字符
		strategy.setControllerMappingHyphenStyle(true);
		mpg.setStrategy(strategy);
		// 选择freemarker引起需要指定如下，注意pom依赖必须要有
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}
}
