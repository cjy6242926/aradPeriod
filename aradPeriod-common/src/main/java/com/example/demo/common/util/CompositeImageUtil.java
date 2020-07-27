package com.example.demo.common.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
//import java.io.FileOutputStream;
import java.io.InputStream;
//import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName: CompositeImageUtil
 * @Description: 图片合成测试类
 * @author chenjy
 * @date 2020年5月31日 上午9:47:23
 *
 */
@Slf4j
public class CompositeImageUtil {

	public static InputStream createShareCard(String ossBigPath, String ossSmallPath, String marketPriceString,
			String saleString) {
		InputStream is = null;
		int x = 40;// 贴图x坐标
		int y = 48;// 贴图y坐标
		int x1 = 444;// 活动价x坐标
		int y1 = 292;// 活动价y坐标
		int x2 = 514;// 销量x坐标
		int y2 = 374;// 销量y坐标
		ossBigPath = ossBigPath + "?x-oss-process=image/resize,l_750";// 设置背景图大小
		ossSmallPath = ossSmallPath + "?x-oss-process=image/resize,l_362";// 设置商品图片大小
		saleString = saleString + "件";
		try {
			// 从oss上获取背景图
			URL ossBigPathUrl = new URL(ossBigPath);
			HttpURLConnection httpURLConnection = (HttpURLConnection) ossBigPathUrl.openConnection();
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("GET");
			InputStream bigIs = httpURLConnection.getInputStream();// 获取背景图流文件
			BufferedImage bigIsImage = ImageIO.read(bigIs);// 获取背景图文件
			bigIs.close();// 关闭背景图输入流
			// 从oss上获取贴图
			URL ossSmallPathUrl = new URL(ossSmallPath);
			HttpURLConnection smallHttpURLConnection = (HttpURLConnection) ossSmallPathUrl.openConnection();
			smallHttpURLConnection.setDoOutput(true);
			smallHttpURLConnection.setRequestMethod("GET");
			InputStream smallIs = smallHttpURLConnection.getInputStream();// 获取贴图流文件
			BufferedImage smallIsImage = ImageIO.read(smallIs);// 获取贴图文件
			Graphics2D g = bigIsImage.createGraphics();
			smallIs.close();// 关闭贴图输入流
			// 画图片(贴图)
			g.drawImage(smallIsImage, x, y, null);
			// 画文字(销量)
			Font salesFont = new Font("PingFang-SC-Medium", Font.BOLD, 40);
			Color salesColor = Color.red;
			g.setFont(salesFont);
			g.setColor(salesColor);
			g.drawString(marketPriceString, x1, y1);
			// 画文字(活动价)
			Font marketPriceFont = new Font("PingFang-SC-Medium", Font.BOLD, 23);
			Color marketPriceColor = Color.red;
			g.setFont(marketPriceFont);
			g.setColor(marketPriceColor);
			g.drawString(saleString, x2, y2);
			g.dispose();
			ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(bigIsImage, "png", arrayOutputStream);
			is = new ByteArrayInputStream(arrayOutputStream.toByteArray());
			// 生成图片到本地
			arrayOutputStream.close();
			is.close();// 关闭生成图输入流
			log.info("生成商品分享图片成功，返回输入流");
		} catch (Exception e) {
			log.info("生成商品分享图片出现异常{}", e);
		}
		return is;
	}

	public static void main(String[] args) {
//		InputStream is = null;
//		int x = 40;// 贴图x坐标
//		int y = 48;// 贴图y坐标
//		int x1 = 444;// 活动价x坐标
//		int y1 = 292;// 活动价y坐标
//		int x2 = 514;// 销量x坐标
//		int y2 = 374;// 销量y坐标
//		String marketPriceString = "400.00";// 活动价字符串
//		String saleString = "109" + "件";// 销量字符串
//		String ossBigPath = "https://kdyplatform.oss-cn-hangzhou.aliyuncs.com/platform/regist/7/8d50e7e5-76cd-49ea-8efe-73c81755116d.jpeg"
//				+ "?x-oss-process=image/resize,l_750";// 此处为拼团卡片背景图路径
//		String ossSmallPath = "https://kdyplatform.oss-cn-hangzhou.aliyuncs.com/app_mall/9/image/8bf03806-bdc3-4193-8bfe-03eac3d9f46b.png"
//				+ "?x-oss-process=image/resize,l_362";// 此处为拼团卡片商品图路径
//		// 参数表示图片高度缩放到362单位；宽度等比
//		try {
////			String imgPath = "F:\\Temp\\Picture\\grouponCard.png";// 背景图片路径
////			BufferedImage backgroundImg = ImageIO.read(new File(imgPath));
////			String upImgPath = "F:\\Temp\\Picture\\21.png";// 贴图路径
////			BufferedImage img01 = ImageIO.read(new File(upImgPath));
//			// 从oss上获取背景图
//			URL ossBigPathUrl = new URL(ossBigPath);
//			HttpURLConnection httpURLConnection = (HttpURLConnection) ossBigPathUrl.openConnection();
//			httpURLConnection.setDoOutput(true);
//			httpURLConnection.setRequestMethod("GET");
//			InputStream bigIs = httpURLConnection.getInputStream();// 获取背景图流文件
//			BufferedImage bigIsImage = ImageIO.read(bigIs);// 获取背景图文件
//			bigIs.close();// 关闭背景图输入流
//			// 从oss上获取贴图
//			URL ossSmallPathUrl = new URL(ossSmallPath);
//			HttpURLConnection smallHttpURLConnection = (HttpURLConnection) ossSmallPathUrl.openConnection();
//			smallHttpURLConnection.setDoOutput(true);
//			smallHttpURLConnection.setRequestMethod("GET");
//			InputStream smallIs = smallHttpURLConnection.getInputStream();// 获取贴图流文件
//			BufferedImage smallIsImage = ImageIO.read(smallIs);// 获取贴图文件
//			Graphics2D g = bigIsImage.createGraphics();
//			smallIs.close();// 关闭贴图输入流
//			// 画图片(贴图)
//			g.drawImage(smallIsImage, x, y, null);
//			// 画文字(销量)
//			Font salesFont = new Font("PingFang-SC-Medium", Font.BOLD, 40);
//			// Color salesColor = new Color(250,0,0,1);
//			Color salesColor = Color.red;
//			// FontMetrics salesFontMetrics = g.getFontMetrics(sales);
//			g.setFont(salesFont);
//			g.setColor(salesColor);
//			// 打印销量：400
//			g.drawString(marketPriceString, x1, y1);
//			// 画文字(活动价)
//			Font marketPriceFont = new Font("PingFang-SC-Medium", Font.BOLD, 23);
//			Color marketPriceColor = Color.red;
//			g.setFont(marketPriceFont);
//			g.setColor(marketPriceColor);
//			g.drawString(saleString, x2, y2);
//			g.dispose();
//			ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
//			ImageIO.write(bigIsImage, "png", arrayOutputStream);
//			is = new ByteArrayInputStream(arrayOutputStream.toByteArray());
//			// 生成图片到本地
//			arrayOutputStream.close();
//			is.close();// 关闭生成图输入流
//			OutputStream out = new FileOutputStream("F:\\Temp\\Picture\\21sy.png");// 生成图片路径
//			byte[] b = new byte[1024];
//			while (is.read(b) != -1) {
//				out.write(b);
//			}
//			out.close();// 关闭生成图输出流
//			log.info("生成商品分享图片成功");
//		} catch (Exception e) {
//			log.info("生成商品分享图片出现异常{}", e);
//		}

	}

}
