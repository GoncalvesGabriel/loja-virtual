package br.com.lojavirtual.repository;

import br.com.lojavirtual.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
