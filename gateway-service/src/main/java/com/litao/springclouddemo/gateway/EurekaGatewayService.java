package com.litao.springclouddemo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaGatewayService {

    public static void main(String[] args) {
        SpringApplication.run(EurekaGatewayService.class, args);
    }
}
