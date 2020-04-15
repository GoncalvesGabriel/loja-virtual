package br.com.lojavirtual.validator;

import br.com.lojavirtual.dto.user.CreateUserDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateUserValidator implements Validator<CreateUserDTO> {

  @Override
  public void validate(CreateUserDTO dto) {
      validatePassaword(dto.getPassword(), dto.getRePassword());
  }

  private void validatePassaword(String password, String rePassword) {
      if(!password.equals(rePassword)) {
          throw new RuntimeException("Password and re-passowrd not are equals");
      }
  }
}
