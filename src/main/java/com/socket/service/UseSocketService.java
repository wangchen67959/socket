package com.socket.service;

public interface UseSocketService {

	/**
	 * 推送消息
	 * @param userId 用户id
	 * @param data json数据 
	 */
	public void sedMessage(String userId, String data);
	
	/**
	 * 校验是用户是否存在session
	 * @param userId
	 * @return
	 */
	public Boolean isConnection(String userId);
	
}
