package com.belstu.thesisproject.authservice.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("psycho-user-service")
public interface UserService {
    @GetMapping("/greeting")
    String getGreeting();
}
