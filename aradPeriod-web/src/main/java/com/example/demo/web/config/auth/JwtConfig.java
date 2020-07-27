package com.example.demo.web.config.auth;

import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @ClassName: JwtConfig
 * @Description: JWT配置类
 * @author chenjy
 * @date 2020年5月29日 下午5:50:07
 *
 */
@ConfigurationProperties(prefix = "config.jwt")
@Component
public class JwtConfig {
	private String secret;
	private long expire;
	private String header;

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public long getExpire() {
		return expire;
	}

	public void setExpire(long expire) {
		this.expire = expire;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * 
	 * @Description:生成token
	 * @param subject
	 * @return
	 *
	 */
	public String createToken(String subject) {
		//System.out.println("配置文件读取expire："+expire);
		Date nowDate = new Date();
		Date expireDate = new Date(nowDate.getTime() + expire * 1000);
		return Jwts.builder().setHeaderParam("typ", "JWT").setSubject(subject).setIssuedAt(nowDate)
				.setExpiration(expireDate).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	/**
	 * 
	 * @Description:获取token中注册信息
	 * @param token
	 * @return
	 *
	 */
	public Claims getTokenClaim(String token) {
		try {
			return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	/**
	 * 
	 * @Description:验证token是否过期失效
	 * @param expirationTime
	 * @return
	 *
	 */
	public boolean isTokenExpired(Date expirationTime) {
		return expirationTime.before(new Date());
	}

	/**
	 * 
	 * @Description:获取token失效时间
	 * @param token
	 * @return
	 *
	 */
	public Date getExpirationDateFromToken(String token) {
		return getTokenClaim(token).getExpiration();
	}

	/**
	 * 
	 * @Description:从token中获取用户名
	 * @param token
	 * @return
	 *
	 */
	public String getUsernameFromToken(String token) {
		return getTokenClaim(token).getSubject();
	}

	/**
	 * 
	 * @Description:获取jwt发布时间
	 * @param token
	 * @return
	 *
	 */
	public Date getIssuedAtDateFromToken(String token) {
		return getTokenClaim(token).getIssuedAt();
	}
	
}
