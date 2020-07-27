package com.example.demo.common.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName: JsoupUtil
 * @Description: jsoup使用
 * @author chenjy
 * @date 2020年5月19日 下午2:26:10
 *
 */
@Slf4j
public class JsoupUtil {

	public static void main(String[] args) {
		//log.info("测试如下：");
//		String html = "<html><head><title>First parse</title></head>"
//				+ "<body><p>Parsed HTML into a doc.</p></body></html>";
//		Document doc = parseHtml(html);
//		System.out.println(doc.html());
//		String html = "<div><p>Lorem ipsum.</p>";
//		Document doc = Jsoup.parseBodyFragment(html);
//		Element body =doc.body();
//		System.out.println(body.html());
		// get请求
//		try {
//			Document doc = Jsoup.connect("http://example.com/").get();
//			String title = doc.title();
//			System.out.println(title);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		// post请求
//		try {
//			Document doc = Jsoup.connect("http://example.com").data("query", "Java").userAgent("Mozilla").cookie("auth", "token").timeout(3000).post();
//			System.out.println(doc.html());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		// 从文件加载文档
//		File input = new File("C:/Users/62429/Desktop/test.html");
//		try {
//			Document doc = Jsoup.parse(input,"UTF-8","http://example.com/");
//			System.out.println(doc.title());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// 使用 DOM 方法导航文档
//		File input = new File("C:/Users/62429/Desktop/test.html");
//		try {
//			Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
//			Element content = doc.getElementById("content");
//			Elements links = content.getElementsByTag("a");
//			for (Element link : links) {
//				String linkHref = link.attr("href");
//				String linkText = link.text();
//				System.out.println("linkHref :" + linkHref + " linkText :" + linkText);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		// 清理不受信任的 HTML（以防止 XSS）
//		String unsafe = "<p><a href='http://example.com/' onclick='stealCookies()'>Link</a></p>";
//		String safe = Jsoup.clean(unsafe, Whitelist.basic());
//		System.out.println(safe);
	}

	/**
	 * 
	 * @Description:将html字符串转换为dom对象
	 * @param html
	 * @return
	 *
	 */
	public static Document parseHtml(String html) {
		log.info("将html字符串转换为dom对象");
		Document doc = Jsoup.parse(html);
		return doc;
	}
}
