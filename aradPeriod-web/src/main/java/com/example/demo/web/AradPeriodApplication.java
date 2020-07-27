package com.example.demo.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan({"com.example.demo.web.mapper"})//扫描mapper接口
//@ComponentScan(basePackages = {"com.example.demo.common","com.example.demo.web.ctrl"})//扫描接口与对应的实现类
@ComponentScan(basePackages = {"com.example.demo.common","com.example.demo.web"})
public class AradPeriodApplication {

	public static void main(String[] args) {
		SpringApplication.run(AradPeriodApplication.class, args);
	}

}
