package com.example.demo.common.util;

import java.awt.Color;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import org.patchca.color.ColorFactory;
import org.patchca.filter.predefined.WobbleRippleFilterFactory;
import org.patchca.font.RandomFontFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.text.renderer.BestFitTextRenderer;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName: VerificationCodeUtil
 * @Description: 验证码工具类
 * @author chenjy
 * @date 2020年5月30日 下午1:35:28
 *
 */
@Slf4j
public class VerificationCodeUtil {
	private static Random random = new Random();

	public static String generateVerificationCode(OutputStream os, int width, int height) {
		ConfigurableCaptchaService css = new ConfigurableCaptchaService();
		RandomFontFactory ff = new RandomFontFactory();
		RandomWordFactory rwf = new RandomWordFactory();
		BestFitTextRenderer tr = new BestFitTextRenderer();
		ff.setRandomStyle(true);
		ff.setMaxSize(20);
		ff.setMinSize(16);
		rwf.setMaxLength(4);
		rwf.setMinLength(4);
		tr.setTopMargin(5);
		tr.setBottomMargin(5);
		tr.setLeftMargin(5);
		tr.setRightMargin(5);
		css.setTextRenderer(tr);
		css.setFontFactory(ff);
		css.setWordFactory(rwf);
		css.setColorFactory(new ColorFactory() {

			@Override
			public Color getColor(int x) {
				int[] c = new int[3];
				int i = random.nextInt(c.length);
				for (int fi = 0; fi < c.length; fi++) {
					if (fi == i) {
						c[fi] = random.nextInt(71);
					} else {
						c[fi] = random.nextInt(256);
					}
				}
				return new Color(c[0], c[1], c[2]);
			}
		});
		css.setFilterFactory(new WobbleRippleFilterFactory());
		css.setWidth(width);
		css.setHeight(height);
		String captcha = null;
		try {
			captcha = EncoderHelper.getChallangeAndWriteImage(css, "png", os);
			// System.out.println("验证码：" + captcha);
			log.info("验证码生成成功：{}", captcha);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return captcha;
	}

//	public static void main(String[] args) {
//		try {
//			String aaa = VerificationCodeUtil.generateVerificationCode(
//					new FileOutputStream(new File("F:\\Temp\\Picture\\captchaCode.png")), 200, 100);
//			System.out.println("验证码：" + aaa);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
}
