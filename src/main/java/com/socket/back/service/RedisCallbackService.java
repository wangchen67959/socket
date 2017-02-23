package com.socket.back.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.socket.proBean.RedisXmlBean;
import com.socket.util.JedisUtil;


/**
 * redis disconf Xml配置方式  文件回调以支持自动注入(在xml中非自动reload的文件，写回调也会执行)
 * 
 * 存在 Autowired 则该类必须被spring托管(添加@service)
 * @author wangchen20097
 *
 */
@Service
//@DisconfUpdateService(confFileKeys = {"redis.properties"})
public class RedisCallbackService implements IDisconfUpdate{
	protected static final Logger LOGGER = LoggerFactory
			.getLogger(RedisCallbackService.class);
	private Jedis jedis = null;
	@Autowired
	private RedisXmlBean redisXmlBean;
	
	@Override
	public void reload() throws Exception {
		LOGGER.info("redis  callback  do..."+redisXmlBean.getHost()+" "+redisXmlBean.getPort());
		jedis = JedisUtil.createJedis(redisXmlBean.getHost(),Integer.parseInt(redisXmlBean.getPort()));
	}
}
