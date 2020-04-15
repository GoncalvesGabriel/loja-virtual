package br.com.lojavirtual.service;

import br.com.lojavirtual.dto.CreateUserDTO;
import br.com.lojavirtual.dto.UserDTO;
import br.com.lojavirtual.entity.User;
import br.com.lojavirtual.repository.UserRepository;
import br.com.lojavirtual.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  @Autowired
  Validator<CreateUserDTO> validator;

  @Autowired
  UserRepository userRepository;

  public UserDTO create(CreateUserDTO userDTO) {
    validator.validate(userDTO);
    User user = userDTO.createUser();
    userRepository.save(user);
    return new UserDTO(user);
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}
