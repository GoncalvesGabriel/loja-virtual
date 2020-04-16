package br.com.lojavirtual.controller;

import br.com.lojavirtual.dto.user.CreateUserDTO;
import br.com.lojavirtual.dto.user.UserDTO;
import br.com.lojavirtual.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@Api("User API")
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @ApiOperation(value = "Create new user", consumes = "application/json", httpMethod = "POST")
  @ApiResponse(code = 201, message = "Uroduct successfully created")
  @PostMapping(consumes = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public UserDTO create(@Valid @RequestBody CreateUserDTO user) {
      return userService.create(user);
  }

  @ApiOperation(value = "Delete one user with a specific id", httpMethod = "DELETE")
  @ApiResponse(code = 200, message = "User successfully deleted")
  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable Long id) {
    userService.delete(id);
  }
}
