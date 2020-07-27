package com.example.demo.common.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName: JsonMessageUtil
 * @Description: json格式化工具
 * @author chenjy
 * @date 2020年5月21日 上午11:54:51
 *
 */
public class JsonMessageUtil {
	private Map<String, Object> msgMap;

	private JsonMessageUtil() {
		this.msgMap = new HashMap<String, Object>();
	}

	public JsonMessageUtil push(String msgKey, Object msgContent) {
		msgMap.put(msgKey, msgContent);
		return this;
	}

	public Map<String, Object> end() {
		return msgMap;
	}

	public static JsonMessageUtil newMsg() {
		return new JsonMessageUtil();
	}

	public static void plainText(HttpServletResponse response, String msg) {
		try {
			response.getWriter().print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
