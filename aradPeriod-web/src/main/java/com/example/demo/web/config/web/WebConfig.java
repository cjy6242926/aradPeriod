package com.example.demo.web.config.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.web.interceptor.TokenInterceptor;

/**
 * 
 * @ClassName: WebConfig
 * @Description: 注册拦截器到SpringMvc
 * @author chenjy
 * @date 2020年5月29日 下午6:26:12
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Resource
	private TokenInterceptor tokenInterceptor;

	public void addInterceptors(InterceptorRegistry registry) {
		// token验证拦截器拦截所有的请求
		registry.addInterceptor(tokenInterceptor).addPathPatterns("/**");
	}

	/**
	 * 放行部分请求
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	}
}
