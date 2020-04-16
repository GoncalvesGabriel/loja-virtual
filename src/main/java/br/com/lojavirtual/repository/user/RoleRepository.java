package br.com.lojavirtual.repository.user;

import br.com.lojavirtual.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
