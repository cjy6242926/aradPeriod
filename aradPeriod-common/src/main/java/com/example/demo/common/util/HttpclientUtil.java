package com.example.demo.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName: HttpclientUtil
 * @Description: 使用HttpClient发送请求、接收响应
 * @author chenjy
 * @date 2020年5月13日 下午6:08:41
 *
 */
@Slf4j
public class HttpclientUtil {
	public static void main(String[] args) {

		String uriPath = "https://www.alphavantage.co/query";
		String keyOne = "Realtime Currency Exchange Rate";
		Map<String, String> map = new HashMap<String, String>();
		map.put("function", "CURRENCY_EXCHANGE_RATE");
		map.put("from_currency", "USD");
		map.put("to_currency", "JPY");
		map.put("apikey", "KWD6WTKWBWGWNZW0");
		JSONObject jsonObject = doGet(uriPath, keyOne, map);
		System.out.println("1. From_Currency Code :" + jsonObject.get("1. From_Currency Code"));
		System.out.println("5. Exchange Rate :" + jsonObject.get("5. Exchange Rate"));
		System.out.println("5. Exchange Rate :" + jsonObject.getString("1. From_Currency Code"));
		System.out.println("jsonObject.get(\"8. Bid Price\").toString() :" + jsonObject.get("8. Bid Price").toString());
		System.out.println("jsonObject.get(\"9. Ask Price\").toString() :" + jsonObject.get("9. Ask Price").toString());

	}

	/**
	 * 
	 * @Description:使用HttpClient发送带参数get请求、接收响应
	 * @param uriPath
	 * @param keyOne
	 * @param map
	 * @return
	 *
	 */
	public static JSONObject doGet(String uriPath, String keyOne, Map<String, String> map) {
		JSONObject jsonObject = null;
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建response对象
		CloseableHttpResponse response = null;
		try {
			// 定义请求的参数
			URIBuilder uriBuilder = new URIBuilder(uriPath);
			// 遍历参数集合
			for (String s : map.keySet()) {
				uriBuilder.setParameter(s, map.get(s));
			}
			// 定义请求的参数
			URI uri = uriBuilder.build();
			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);
			// 执行http get请求
			response = httpClient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				String content = EntityUtils.toString(response.getEntity(), "UTF-8");
				JSONObject json = JSONObject.parseObject(content);
				// json里取json
				jsonObject = json.getJSONObject(keyOne);
			}

		} catch (URISyntaxException e) {
			log.error("HttpclientUtil-line-145 URISyntaxException：{}", e.getMessage());
		} catch (ClientProtocolException e1) {
			log.error("HttpclientUtil-line-147 ClientProtocolException：{}", e1.getMessage());
		} catch (IOException e2) {
			log.error("HttpclientUtil-line-149 IOException：{}", e2.getMessage());
		} finally {
			if (response != null) {
				try {
					// 断开与服务端连接
					response.close();
				} catch (IOException e3) {
					log.error("HttpclientUtil-line-156 IOException：{}", e3.getMessage());
				}
			}
			try {
				// 相当于关闭浏览器
				httpClient.close();
			} catch (IOException e4) {
				log.error("HttpclientUtil-line-163 IOException：{}", e4.getMessage());
			}
		}
		return jsonObject;
	}

	/**
	 * 
	 * @Description:发送不带参数的post请求，返回页面字符串
	 * @param url
	 * @return
	 *
	 */
	public static String doPostNoParam(String url) {
		String str = "";
		// 创建httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建http pist请求
		HttpPost httpPost = new HttpPost(url);
		// 伪装浏览器请求
		httpPost.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
		CloseableHttpResponse response = null;
		try {
			// 执行请求
			response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				String content = EntityUtils.toString(response.getEntity(), "UTF-8");
				// 打印文件
				// System.out.println("content :" + content);
				str = content;
			}
		} catch (ClientProtocolException e) {
			log.error("doPostNoParam ClientProtocolException异常：{}", e.getMessage());
		} catch (IOException e) {
			log.error("doPostNoParam IOException异常：{}", e.getMessage());
		} finally {
			if (response != null) {
				try {
					// 断开与服务器连接
					response.close();
				} catch (IOException e) {
					log.error("doPostNoParam line-201-IOException异常：{}", e.getMessage());
				}
			}
			try {
				// 相当于关闭浏览器
				httpClient.close();
			} catch (IOException e) {
				log.error("doPostNoParam line-208-IOException异常：{}", e.getMessage());
			}
		}
		return str;
	}

	/**
	 * 
	 * @Description:发送带参数的post请求，返回页面字符串
	 * @param url
	 * @param map
	 * @return
	 *
	 */
	public static String doPostParam(String url, Map<String, String> map) {
		String str = "";
		// 创建httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建http pist请求
		HttpPost httpPost = new HttpPost(url);
		// 伪装浏览器
		httpPost.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
		CloseableHttpResponse response = null;
		// 设置2个post参数，一个是scope，一个是q
		List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
		for (String temp : map.keySet()) {
			parameters.add(new BasicNameValuePair(temp, map.get(temp)));
		}
		try {
			// 构造一个form表单式的实体
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
			// 将请求实体放到httpPost对象中
			httpPost.setEntity(formEntity);
			// 执行请求
			response = httpClient.execute(httpPost);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				// 返回为页面
				String content = EntityUtils.toString(response.getEntity(), "UTF-8");
				str = content;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return str;

	}
}
