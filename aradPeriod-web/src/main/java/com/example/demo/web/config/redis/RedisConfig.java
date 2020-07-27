package com.example.demo.web.config.redis;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @ClassName: RedisConfig
 * @Description: redis控制类
 * @author chenjy
 * @date 2020年6月2日 下午3:03:27
 *
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {
	/**
	 * 
	 * @Description:配置自定义redisTemplate
	 * @param lettuceConnectionFactory
	 * @return
	 *
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(lettuceConnectionFactory);
		// 使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
		Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		serializer.setObjectMapper(mapper);
		template.setValueSerializer(serializer);
		// 使用StringRedisSerializer来序列化和反序列化redis的key值
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.afterPropertiesSet();
		return template;
	}

}
