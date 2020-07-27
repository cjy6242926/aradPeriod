package com.example.demo.web.ctrl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
	@RequestMapping("/hello")
	public String helloworld() {
		System.out.println("aaa");
		return "hello world";
	}

	/**
	 * 
	 * @Description:添加cookie
	 * @param request
	 * @param response
	 *
	 */
	@RequestMapping(value = "/addCookie", method = RequestMethod.GET)
	public String addCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie = new Cookie("queryCookie", "queryCookie");
		cookie.setMaxAge(60 * 60);
		cookie.setPath("/");
		System.out.println("cookie过期时间设置为：" + 3600);
		response.addCookie(cookie);
		return "cookie已设置，name：" + cookie.getName() + " maxAge：" + cookie.getMaxAge() + " path：" + cookie.getPath();
	}

	/**
	 * 
	 * @Description:打印cookie过期时间
	 * @param request
	 * @param response
	 *
	 */
	@RequestMapping(value = "/queryCookie", method = RequestMethod.GET)
	public String queryCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String aString = "";
		int bString = 0;
		String cString = "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("queryCookie")) {
				System.out.println("打印cookie名称：" + cookie.getName());
				aString = cookie.getName();
				System.out.println("打印cookie过期时间：" + cookie.getMaxAge());
				bString = cookie.getMaxAge();
				cString = cookie.getPath();
			}
		}
		return "查询cookie成功，name：" + aString + " maxAge：" + bString + " path：" + cString;
	}

}
