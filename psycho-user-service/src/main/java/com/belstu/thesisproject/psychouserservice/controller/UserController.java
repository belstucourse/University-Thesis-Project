package com.belstu.thesisproject.psychouserservice.controller;

import com.belstu.thesisproject.psychouserservice.domain.User;
import com.belstu.thesisproject.psychouserservice.dto.UserDto;
import com.belstu.thesisproject.psychouserservice.exception.UserNotFoundException;
import com.belstu.thesisproject.psychouserservice.mapper.UserMapper;
import com.belstu.thesisproject.psychouserservice.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable final String id) throws UserNotFoundException {
        return userMapper.map(userService.getUserById(id));
    }

    @GetMapping
    public UserDto getUserByUsername(@RequestParam final String username)
            throws UserNotFoundException {
        return userMapper.map(userService.getUserByUsername(username));
    }

    @PostMapping
    public UserDto saveUser(@RequestBody final UserDto userDto) {
        final User user = userMapper.map(userDto);
        return userMapper.map(userService.save(user));
    }

    @PutMapping
    public UserDto updateUser(@RequestBody final UserDto userDto) throws UserNotFoundException {
        final User user = userMapper.map(userDto);
        return userMapper.map(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public UserDto deleteById(@PathVariable final Integer id) throws UserNotFoundException {
        return userMapper.map(userService.delete(id));
    }

}
