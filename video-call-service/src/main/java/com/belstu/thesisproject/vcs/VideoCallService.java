package com.belstu.thesisproject.vcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class VideoCallService {
  public static void main(String[] args) {
    SpringApplication.run(VideoCallService.class, args);
  }
}
