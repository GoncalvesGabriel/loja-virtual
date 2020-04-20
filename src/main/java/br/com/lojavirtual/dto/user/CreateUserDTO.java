package br.com.lojavirtual.dto.user;

import br.com.lojavirtual.entity.user.User;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@NoArgsConstructor
@AllArgsConstructor
public @Data class CreateUserDTO {

  @NotNull
  @ApiModelProperty(value = "Nome do usuário (usado para login)")
  private String name;

  @NotNull
  @ApiModelProperty(value = "Email do usuário")
  private String email;

  @NotNull
  @ApiModelProperty(value = "Senha de acesso")
  private String password;

  @NotNull
  @ApiModelProperty(value = "Confirmação da senha de acesso")
  private String rePassword;

  public User createUser(){
    return new User(null, this.name, this.email, new BCryptPasswordEncoder().encode(password), new ArrayList<>());
  }

}
