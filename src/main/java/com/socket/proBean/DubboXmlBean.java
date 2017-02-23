package com.socket.proBean;

/**
 * xml分布式配置 javaBean
 * @author wangchen20097
 *
 */
public class DubboXmlBean {
	
	private String applicationName;

	private String registryAddress;

	private String monitorProtocol;

	private String protocolName;

	private int protocolPort;
	
	private String registryRegister;

	public String getRegistryRegister() {
		return registryRegister;
	}

	public void setRegistryRegister(String registryRegister) {
		this.registryRegister = registryRegister;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getRegistryAddress() {
		return registryAddress;
	}

	public void setRegistryAddress(String registryAddress) {
		this.registryAddress = registryAddress;
	}

	public String getMonitorProtocol() {
		return monitorProtocol;
	}

	public void setMonitorProtocol(String monitorProtocol) {
		this.monitorProtocol = monitorProtocol;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public int getProtocolPort() {
		return protocolPort;
	}

	public void setProtocolPort(int protocolPort) {
		this.protocolPort = protocolPort;
	}
}
