package com.belstu.thesisproject.authservice.service;

import com.belstu.thesisproject.authservice.dto.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("psycho-user-service")
public interface UserService {
    @GetMapping("/greeting")
    UserDto getUserByUsername(@RequestParam(name="username") final String username);
}
