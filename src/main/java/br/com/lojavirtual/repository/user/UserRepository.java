package br.com.lojavirtual.repository.user;

import br.com.lojavirtual.entity.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByName(String name);
}
