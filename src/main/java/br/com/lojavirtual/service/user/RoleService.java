package br.com.lojavirtual.service.user;

import br.com.lojavirtual.entity.user.Role;
import br.com.lojavirtual.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

  @Autowired
  RoleRepository repository;

  private static long USER_ROLE = 2L;

  public Role getUserRole() {
    return repository.getOne(USER_ROLE);
  }


}
