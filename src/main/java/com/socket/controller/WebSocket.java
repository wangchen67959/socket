package com.socket.controller;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.socket.util.SessionUtil;

@ServerEndpoint("/flyfishWebSocket/{userId}")
@Component
public class WebSocket {
	
	public static final Logger log = Logger.getLogger(WebSocket.class);
	
	@OnOpen
	public void open(Session session, @PathParam("userId") String userId) {
		log.info(userId + "已链接成功");
		if(!SessionUtil.hasKey(userId)) {
			SessionUtil.put(userId, session);
			SessionUtil.addOnlineCount();
		}
		log.info("当前已连接个数为:" + SessionUtil.getOnlineCount());
	}

	@OnMessage
	public void inMessage(String message) {
		log.info(message);
	}

	@OnClose
	public void end(Session session, CloseReason reason, @PathParam("userId") String userId) {
		Session s = (Session) SessionUtil.get(userId);
		try {
			if(null == s) {
				log.error("该用户未创建session");
			}else {
				s.close();
			}
		} catch (Exception e) {
			log.error("关闭session异常", e);
		}
		finally{
			SessionUtil.remove(userId);
			SessionUtil.subOnlineCount();
		}
	}
}
