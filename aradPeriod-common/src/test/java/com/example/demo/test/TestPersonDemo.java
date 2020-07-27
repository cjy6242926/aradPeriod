package com.example.demo.test;

import java.util.ArrayList;
//import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.serializer.BeanContext;
//import com.alibaba.fastjson.serializer.ContextValueFilter;
import com.example.demo.common.entity.TestPerson;
import com.example.demo.common.util.FastjsonUtil;

/**
 * 
 * @ClassName: TestPerson
 * @Description: fastjson测试类
 * @author chenjy
 * @date 2020年5月20日 上午11:48:18
 *
 */

public class TestPersonDemo {
	@SuppressWarnings("unused")
	private List<TestPerson> listOfPersons = new ArrayList<TestPerson>();

	/**
	 * 
	 * @Description:将 Java 对象转换换为 JSON 对象
	 *
	 */
	@Test
	public void whenJavaList_thanConvertToJsonCorrect() {
//		TestPerson t1 = new TestPerson(15, "John", new Date());
//		t1.setId(1);
//		TestPerson t2 = new TestPerson(16, "Tom", new Date());
//		t2.setId(1);
//		listOfPersons.add(t1);
//		listOfPersons.add(t2);
//		String jsonOutput = JSON.toJSONString(listOfPersons);
//		System.out.println(jsonOutput);
	}

	/**
	 * 
	 * @Description:JSONObject（fastJson提供的json对象） 和 JSONArray（fastJson提供json数组对象） 对象
	 *
	 */
	@Test
	public void whenGenerateJson_thanGenerationCorrect() {
		Map<String, Object> map = new HashMap<String, Object>();
		TestPerson t1 = new TestPerson();
		t1.setId(1);
		t1.setFullName("刘备");
		TestPerson t2 = new TestPerson();
		t2.setId(2);
		t2.setFullName("关羽");
		TestPerson t3 = new TestPerson();
		t3.setId(3);
		t3.setFullName("张飞");
		map.put("1", t1);
		map.put("2", t2);
		map.put("3", t3);
		String jsonOutput = FastjsonUtil.jsonObjectMethod(map);
		System.out.println(jsonOutput);
	}

	/**
	 * 
	 * @Description:json字符串转换为java对象
	 *
	 */
	@Test
	public void whenJson_thanConvertToObjectCorrect() {
//		TestPerson t1 = new TestPerson(15, "John", new Date());
//		String jsonObject = JSON.toJSONString(t1);
		String jsonObject = "{\"age\":15,\"fullName\":\"John\",\"dateOfBirth02\":\"21/05/2020\"}";
		// TestPerson newPerson = JSON.parseObject(jsonObject, TestPerson.class);
		TestPerson newPerson = (TestPerson) FastjsonUtil.jsonToJava(jsonObject, TestPerson.class);
		System.out.println(newPerson);
	}

	/**
	 * 
	 * @Description:使用 ContextValueFilter 配置 JSON 转换
	 *
	 */
	@Test
	public void givenContextFilter_whenJavaObject_thanJsonCorrect() {
		// 隐藏了 DATE OF BIRTH 字段，并过滤名字不包含 John 的字段
//		ContextValueFilter valueFilter = new ContextValueFilter() {
//
//			@Override
//			public Object process(BeanContext context, Object object, String name, Object value) {
//				if ("DATE OF BIRTH".equals(name)) {
//					return "NOT TO DISCLOSE";
//				}
//				if ("John".equals(value)) {
//					return ((String) value).toUpperCase();
//				} else {
//					return null;
//				}
//			}
//		};
//		TestPerson t1 = new TestPerson(15, "John", new Date());
//		t1.setId(1);
//		TestPerson t2 = new TestPerson(16, "Tom", new Date());
//		t2.setId(2);
//		listOfPersons.add(t1);
//		listOfPersons.add(t2);
//		String jsonOutput = JSON.toJSONString(listOfPersons, valueFilter);
//		System.out.println(jsonOutput);
	}
}
