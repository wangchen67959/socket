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
	
//	@Bean
//	public EmbeddedServletContainerFactory servletContainerFactory() {
//		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
//		factory.setPort(8899);
//		factory.setSessionTimeout(10, TimeUnit.MINUTES);
////		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
//		return factory;
//	}
}
