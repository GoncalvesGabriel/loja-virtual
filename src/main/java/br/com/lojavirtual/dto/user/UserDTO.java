package br.com.lojavirtual.dto.user;

import br.com.lojavirtual.entity.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

public @Data class UserDTO {

  @ApiModelProperty(value = "Id do usuário")
  private Long id;

  @ApiModelProperty(value = "Nome do usuário (usado para login)")
  private String name;

  @ApiModelProperty(value = "Email do usuário")
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
