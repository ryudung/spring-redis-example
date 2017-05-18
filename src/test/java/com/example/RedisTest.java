package com.example;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	
	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> valusOps;
	
	@Test
	public void 레디스_테스트_기록() {
		valusOps.set("spring:redis:hello", "Hello, Spring Redis");
	}
	
	@Test
	public void 레디스_테스트_읽기() {		
		System.out.println("result ====> " + valusOps.get("spring:redis:hello"));
	}	
}
