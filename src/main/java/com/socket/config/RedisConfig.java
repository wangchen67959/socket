package com.socket.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;

/**
 * 使用注解方式进行配置更新重载
 * @author wangchen20097
 *
 */
@Service
@Scope("singleton")
//@DisconfFile(filename = "redis.properties")
//@DisconfUpdateService(classes = {RedisConfig.class})
public class RedisConfig implements IDisconfUpdate {

	 protected static final Log LOGGER = LogFactory.getLog(RedisConfig.class);

	// 代表连接地址
	private String host;

	// 代表连接port
	private int port;

	/**
	 * 地址, 分布式文件配置
	 *
	 * @return
	 */
	@DisconfFileItem(name = "redis.host", associateField = "host")
	public String getHost() {

		return host;
	}

	public void setHost(String host) {

		this.host = host;
	}

	/**
	 * 端口, 分布式文件配置
	 *
	 * @return
	 */
	@DisconfFileItem(name = "redis.port", associateField = "port")
	public int getPort() {

		return port;
	}

	public void setPort(int port) {

		this.port = port;
	}

	public void reload() throws Exception {
		System.out.println("host: " + host +"port:" +port);
		LOGGER.info("host: " + host +"port:" +port);
	}
}
