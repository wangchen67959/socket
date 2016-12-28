package com.socket.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@EnableAutoConfiguration
@Controller
@SpringBootApplication
public class StartSpringBoot {
	
	@RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello ,spring boot!";
    }

	public static void main(String[] args) {
		SpringApplication.run(StartSpringBoot.class, args);
	}
//	@Bean
//	public EmbeddedServletContainerFactory servletContainer(){
//		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
//		factory.setPort(8899);
//		factory.setSessionTimeout(20, TimeUnit.MINUTES);
//		return factory;
//		
//	}
}
