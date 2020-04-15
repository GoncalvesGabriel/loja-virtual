package br.com.lojavirtual.controller;

import br.com.lojavirtual.dto.CreateUserDTO;
import br.com.lojavirtual.dto.UserDTO;
import br.com.lojavirtual.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UserDTO create(@RequestBody CreateUserDTO user) {
      return userService.create(user);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable Long id) {
    userService.delete(id);
  }
}
