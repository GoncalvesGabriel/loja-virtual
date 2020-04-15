package br.com.lojavirtual.dto;

import br.com.lojavirtual.entity.User;
import lombok.Data;

public @Data class UserDTO {

  private Long id;

  private String name;

  private String email;

  public UserDTO(User user) {
    this.setId(user.getId());
    this.setName(user.getName());
    this.setEmail(user.getEmail());
  }
}
