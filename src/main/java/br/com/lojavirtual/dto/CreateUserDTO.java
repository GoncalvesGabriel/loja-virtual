package br.com.lojavirtual.dto;

import br.com.lojavirtual.entity.User;
import lombok.Data;

public @Data class CreateUserDTO {

  private String name;

  private String email;

  private String password;

  private String rePassword;

  public User createUser(){
    return new User(null, this.name, this.email, password);
  }

}
