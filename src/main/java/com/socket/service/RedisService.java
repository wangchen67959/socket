package com.socket.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;

import com.socket.config.RedisConfig;
import com.socket.util.JedisUtil;

public class RedisService {
	protected static final Logger LOGGER = LoggerFactory
			.getLogger(RedisService.class);

	// jedis 实例
	private Jedis jedis = null;

	/**
	 * 分布式配置
	 */
	@Autowired
	private RedisConfig redisConfig;

	/**
	 * 关闭
	 */
	public void destroy() throws Exception {

		if (jedis != null) {
			jedis.disconnect();
		}
	}

	/**
	 * 进行连接
	 */
	public void afterPropertiesSet() throws Exception {

		jedis = JedisUtil.createJedis(redisConfig.getHost(),
				redisConfig.getPort());
	}

	/**
	 * 获取一个值
	 *
	 * @param key
	 * @return
	 */
	public String getKey(String key) {
		if (jedis != null) {
			return jedis.get(key);
		}

		return null;
	}

	/**
	 * 更改Jedis
	 */
	public void changeJedis() {

		LOGGER.info("start to change jedis hosts to: " + redisConfig.getHost()
				+ " : " + redisConfig.getPort());

		jedis = JedisUtil.createJedis(redisConfig.getHost(),
				redisConfig.getPort());

		LOGGER.info("change ok.");
	}
}
