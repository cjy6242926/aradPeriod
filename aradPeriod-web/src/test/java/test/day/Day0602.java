package test.day;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.example.demo.common.entity.TestUser;

import lombok.extern.slf4j.Slf4j;
import test.TestDemo;

/**
 * 
 * @ClassName: Day0602
 * @Description: 测试类0602
 * @author chenjy
 * @date 2020年6月2日 下午6:35:59
 *
 */
@Slf4j
public class Day0602 extends TestDemo {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Test
	public void test01() {
		TestUser user = new TestUser();
		user.setId(11);
		user.setName("zs");
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		operations.set("fdd2", user);
		boolean exists = redisTemplate.hasKey("fdd2");
		log.info("redis是否存在相应的key：" + exists);
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>) redisTemplate.opsForValue().get("fdd2");
		log.info("从redis数据库获取的user id为：" + map.get("id"));
	}

}
