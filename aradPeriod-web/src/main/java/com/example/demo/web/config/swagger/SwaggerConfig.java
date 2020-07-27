package com.example.demo.web.config.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @ClassName: SwaggerConfig
 * @Description: Swagger控制类
 * @author chenjy
 * @date 2020年7月17日 下午3:33:40
 *
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enabled", havingValue = "true")
public class SwaggerConfig {
	@Value("${swagger.enabled}")
	private boolean swaggerEnabled;

	@Bean
	public Docket docket() {
		// System.out.println("打印swaggerEnabled：" + swaggerEnabled);
		ParameterBuilder parameterBuilder = new ParameterBuilder();
		List<Parameter> heads = new ArrayList<Parameter>();
		parameterBuilder.name("token").description("访问令牌").modelRef(new ModelRef("String")).parameterType("header").required(false).build();
		heads.add(parameterBuilder.build());
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())// api基础信息
				// .genericModelSubstitutes(Response.class)//
				// .forCodeGeneration(true)
				.enable(swaggerEnabled)// 控制开启或关闭swagger
				.select()// 选择哪些路径和api会生成document
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.web.ctrl"))// 扫描展示api的路径包
				.paths(PathSelectors.any())// 对所有路径进行监控
				.build();// 构建
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API文档")// api名称
				.description("采用swagger2")// api描述
				.version("1.0")// api版本
				.build();// 构建
	}
}
