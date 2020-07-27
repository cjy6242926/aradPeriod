package com.example.demo.common.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @ClassName: FastjsonUtil
 * @Description: Json工具类
 * @author chenjy
 * @date 2020年5月21日 上午9:23:44
 *
 */
public class FastjsonUtil {
	/**
	 * 
	 * @Description:将java对象转json字符串
	 * @param t
	 * @return (展示方法参数和返回值)
	 *
	 */
	public String javaToJson(Class<?> t) {
		return JSON.toJSONString(t);
	}

	/**
	 * 
	 * @Description:将java对象list集合转json字符串
	 * @param list
	 * @return
	 *
	 */
	public String javaListToJson(List<?> list) {
		return JSON.toJSONString(list);
	}

	/**
	 * 
	 * @Description:JSONObject（fastJson提供的json对象）和JSONArray（fastJson提供json数组对象）对象
	 * @param map
	 * @return
	 *
	 */
	public static String jsonObjectMethod(Map<String, Object> map) {
		String jsonOutput = "";
		JSONArray jsonArray = new JSONArray();
		for (String str : map.keySet()) {
			// 此处要新建对象，防止重复引用
			/**
			 * 循环引用：当一个对象包含另一个对象时，fastjson就会把该对象解析成引用
			 */
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(str, map.get(str));
			jsonArray.add(jsonObject);
		}
		jsonOutput = jsonArray.toJSONString();
		return jsonOutput;
	}

	/**
	 * 
	 * @Description:json字符串转java对象
	 * @param jsonObject
	 * @param t
	 * @return
	 *
	 */
	public static Object jsonToJava(String jsonObject, Class<?> t) {
		return JSON.parseObject(jsonObject, t);
	}

	/**
	 * 
	 * @Description 使用ContextValueFilter 配置 JSON 转换
	 *
	 */
//	public static void givenContextFilter_whenJavaObject_thanJsonCorrect() {
//		// 隐藏了 DATE OF BIRTH 字段，并过滤名字不包含 John 的字段
//		ContextValueFilter valueFilter = new ContextValueFilter() {
//
//			@Override
//			public Object process(BeanContext context, Object object, String name, Object value) {
//				if ("birthDay".equals(name)) {
//					return "NOT TO DISCLOSE";
//				}
//				if ("John".equals(value)) {
//					return ((String) value).toUpperCase();
//				} else {
//					return null;
//				}
//			}
//		};
//		JSONObject jsonObject01 = new JSONObject();
//		jsonObject01.put("name", "John");
//		jsonObject01.put("birthDay", "0521");
//		jsonObject01.put("age", "16");
//		JSONObject jsonObject02 = new JSONObject();
//		jsonObject02.put("name", "Tom");
//		jsonObject02.put("birthDay", "0520");
//		jsonObject02.put("age", "17");
//		JSONObject jsonObject03 = new JSONObject();
//		jsonObject03.put("name", "John Jack");
//		jsonObject03.put("birthDay", "0519");
//		jsonObject03.put("age", "18");
//		List<JSONObject> list = new ArrayList<JSONObject>();
//		list.add(jsonObject01);
//		list.add(jsonObject02);
//		list.add(jsonObject03);
//		String jsonOutput = JSON.toJSONString(list, valueFilter);
//		System.out.println(jsonOutput);
//	}
}
