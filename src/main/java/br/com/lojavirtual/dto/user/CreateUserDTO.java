package br.com.lojavirtual.dto.user;

import br.com.lojavirtual.entity.user.User;
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
  private String name;

  @NotNull
  private String email;

  @NotNull
  private String password;

  @NotNull
  private String rePassword;

  public User createUser(){
    return new User(null, this.name, this.email, new BCryptPasswordEncoder().encode(password), new ArrayList<>());
  }

}
