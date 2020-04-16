package br.com.lojavirtual.service.user;

import br.com.lojavirtual.dto.user.CreateUserDTO;
import br.com.lojavirtual.dto.user.UserDTO;
import br.com.lojavirtual.entity.user.User;
import br.com.lojavirtual.repository.user.UserRepository;
import br.com.lojavirtual.validator.Validator;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  @Autowired
  private Validator<CreateUserDTO> validator;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleService roleService;

  public UserDTO create(CreateUserDTO userDTO) {
    validator.validate(userDTO);
    User user = userDTO.createUser();
    user.addRole(roleService.getUserRole());
    userRepository.save(user);
    return new UserDTO(user);
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }

  public User findById(Long id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
      return user.get();
    }
    throw new IllegalArgumentException("User not found");
  }
}
