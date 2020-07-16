package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//让eureka监听，项目启动时自动注册到eureka
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
