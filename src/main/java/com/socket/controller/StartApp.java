package com.socket.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class StartApp {
	public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }
}
