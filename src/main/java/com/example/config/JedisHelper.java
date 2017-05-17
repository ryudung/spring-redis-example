package com.example.config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisHelper {
	protected static final String REDIS_HOST = "192.168.0.46";
	protected static final int REDIS_PORT = 6379;
	
	private JedisPoolConfig config;
	private JedisPool pool;
	
	
	private JedisHelper() {
		this.config = new JedisPoolConfig();
		this.pool = new JedisPool(config, REDIS_HOST, REDIS_PORT);
	}
	
    /**
     * 싱글톤 처리를 위한 홀더 클래스
     * https://blog.seotory.com/post/2016/03/java-singleton-pattern
     * http://changsuk.me/?p=1433
     *
     */	
	private static class HoldLazy {
		private static JedisHelper instance = new JedisHelper();
	}
	
	public static JedisHelper getInstance() {
		return HoldLazy.instance;
	}
	
	public final Jedis getConnection() {
		return pool.getResource();
	}
	
	public final void JedisDistroy() {
		if (pool != null) pool.destroy();
	}

}
