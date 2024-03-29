package com.belstu.thesisproject.psychouserservice.controller;

import static com.belstu.thesisproject.psychouserservice.dto.UserRole.ROLE_CLIENT;
import static java.util.Collections.singleton;
import static org.springframework.http.HttpStatus.OK;

import com.belstu.thesisproject.psychouserservice.domain.User;
import com.belstu.thesisproject.psychouserservice.dto.UserDto;
import com.belstu.thesisproject.psychouserservice.exception.UserNotFoundException;
import com.belstu.thesisproject.psychouserservice.mapper.UserMapper;
import com.belstu.thesisproject.psychouserservice.service.UserService;
import com.belstu.thesisproject.psychouserservice.valiadator.OnCreate;
import com.belstu.thesisproject.psychouserservice.valiadator.OnUpdate;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@Validated
@AllArgsConstructor
public class UserController {
  private final UserService userService;
  private final UserMapper userMapper;

  @GetMapping("/{id}")
  public UserDto getUserById(@PathVariable final String id) throws UserNotFoundException {
    return userMapper.map(userService.getUserById(id));
  }

  @GetMapping
  public UserDto getUserByEmail(@RequestParam final String email) throws UserNotFoundException {
    return userMapper.map(userService.getUserByEmail(email));
  }

  @PostMapping
  @Validated(OnCreate.class)
  public UserDto saveUser(@RequestBody @Valid final UserDto userDto) {
    final User user = userMapper.map(userDto);
    user.setRoles(singleton(ROLE_CLIENT));
    return userMapper.map(userService.save(user));
  }

  @PutMapping
  @Validated(OnUpdate.class)
  public UserDto updateUser(@RequestBody @Valid final UserDto userDto)
      throws UserNotFoundException {
    final User user = userMapper.map(userDto);
    return userMapper.map(userService.update(user));
  }

  @PatchMapping
  public UserDto patchUser(@RequestBody final UserDto userDto) throws UserNotFoundException {
    final User user = userMapper.map(userDto);
    return userMapper.map(userService.patch(user));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = OK)
  public void deleteById(@PathVariable final String id) throws UserNotFoundException {
    userService.delete(id);
  }
}
