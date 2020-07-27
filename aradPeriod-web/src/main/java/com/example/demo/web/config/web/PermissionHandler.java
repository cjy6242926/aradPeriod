package com.example.demo.web.config.web;

import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 
 * @ClassName: PermissionHandler
 * @Description: 统一异常处理类
 * @author chenjy
 * @date 2020年5月29日 下午6:29:49
 *
 */
@RestControllerAdvice
public class PermissionHandler {
	@ExceptionHandler(value = { SignatureException.class })
	@ResponseBody
	public Map<String, Object> authorizationException(SignatureException e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "02");
		map.put("errorType", "SignatureException");
		map.put("errorMsg", e.getMessage());
		return map;
	}
}
