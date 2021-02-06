package com.belstu.thesisproject.mrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MedicalRecordsService {
  public static void main(String[] args) {
    SpringApplication.run(MedicalRecordsService.class, args);
  }
}
