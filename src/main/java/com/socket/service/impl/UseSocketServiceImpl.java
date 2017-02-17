package com.socket.service.impl;

import javax.websocket.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.socket.service.UseSocketService;
import com.socket.util.SessionUtil;

public class UseSocketServiceImpl implements UseSocketService{

	public static final Log log = LogFactory.getLog(UseSocketServiceImpl.class);
	
	public void sedMessage(String userId, String data){
		Session session = (Session) SessionUtil.get(userId);
		try {
			if(null == session) {
				log.error("该用户未创建session");
			}else {
				synchronized (session) {
					session.getBasicRemote().sendText(data);
				}
			}
		} catch (Exception e) {
			SessionUtil.remove(userId);
			SessionUtil.subOnlineCount();
			log.error("发送消息异常sedMessage", e);
		}
	}

	public Boolean isConnection(String userId) {
		return SessionUtil.isConnection(userId);
	}
}