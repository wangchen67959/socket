package com.socket.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
@ImportResource({"classpath:disconf.xml"})//引入disconf
public class StartApp {
	public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }
}
