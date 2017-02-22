package com.socket.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.update.IDisconfUpdate;

//@Configuration
@Service
//@DisconfFile(filename = "dubbo.properties")
public class DubboConfig implements IDisconfUpdate {
	
	private static final Log LOGGER = LogFactory.getLog(RedisConfig.class);

	private String applicationName;

	private String registryAddress;

	private String monitorProtocol;
	
	private String protocolName;

	private int protocolPort;

	@DisconfFileItem(name = "dubbo.monitor.protocol", associateField = "monitorProtocol")
	public String getMonitorProtocol() {
		return monitorProtocol;
	}

	public void setMonitorProtocol(String monitorProtocol) {
		this.monitorProtocol = monitorProtocol;
	}

	@DisconfFileItem(name = "dubbo.application.name", associateField = "applicationName")
	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	@DisconfFileItem(name = "dubbo.registry.address", associateField = "registryAddress")
	public String getRegistryAddress() {
		return registryAddress;
	}

	public void setRegistryAddress(String registryAddress) {
		this.registryAddress = registryAddress;
	}

	@DisconfFileItem(name = "dubbo.protocol.name", associateField = "protocolName")
	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	@DisconfFileItem(name = "dubbo.protocol.port", associateField = "protocolPort")
	public int getProtocolPort() {
		return protocolPort;
	}

	public void setProtocolPort(int protocolPort) {
		this.protocolPort = protocolPort;
	}

	@Override
	public void reload() throws Exception {
		LOGGER.info("DubboConfig [applicationName=" + applicationName
				+ ", registryAddress=" + registryAddress + ", monitorProtocol="
				+ monitorProtocol + ", protocolName=" + protocolName
				+ ", protocolPort=" + protocolPort + "]");
	}
}
