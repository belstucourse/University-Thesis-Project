package com.belstu.thesisproject.psychouserservice.config;

import com.belstu.thesisproject.psychouserservice.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
  @Bean
  public UserMapper userMapper() {
    return UserMapper.INSTANCE;
  }
}
