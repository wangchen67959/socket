package com.socket.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.socket.controller.WebSocket;

public class SessionUtil {
	// 存放session
	private static Map<String, Object> map = new ConcurrentHashMap<String, Object>();
	// 统计个数
	private static int onlineCount = 0;
	
	public static void put(String key, Object val){
		map.put(key,val);
	}
	
	public static Boolean isConnection(String userId){
		Boolean flag = true;
		if(null == map.get(userId)){
			flag = false;
		}
		return flag;
	}
	public static Boolean hasKey(String userId){
		return map.containsKey(userId);
	}
	
	public static void remove(String userId){
		map.remove(userId);
	}
	public static Object get(String userId) {
		return map.get(userId);
	}
	
	public static synchronized int getOnlineCount (){  
        return SessionUtil.onlineCount;  
    }  
  
    public static synchronized void addOnlineCount (){  
    	SessionUtil.onlineCount++;  
    }  
  
    public static synchronized void subOnlineCount (){  
    	SessionUtil.onlineCount--;  
    }  
}
