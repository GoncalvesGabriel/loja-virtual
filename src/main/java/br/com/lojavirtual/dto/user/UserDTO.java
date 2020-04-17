package br.com.lojavirtual.dto.user;

import br.com.lojavirtual.entity.user.User;
import lombok.Builder;
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

  @Builder
  public UserDTO(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }
}
