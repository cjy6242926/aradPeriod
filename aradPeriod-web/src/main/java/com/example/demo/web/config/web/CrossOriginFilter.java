package com.example.demo.web.config.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName: CrossOriginFilter
 * @Description: 拦截器--解决跨域请求
 * @author chenjy
 * @date 2020年5月21日 上午11:27:15
 *
 */
//@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@WebFilter(urlPatterns = "/*")
public class CrossOriginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String origin = httpServletRequest.getHeader("Origin");
		httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,x-token,content-type,x-token,token");
		//httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
		String method = httpServletRequest.getMethod();
		if (method.equalsIgnoreCase("OPTIONS")) {
			//log.info("CrossOriginFilter--Line--53--Priint--Success");
			response.getOutputStream().write("Success".getBytes("utf-8"));
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
	}

}
