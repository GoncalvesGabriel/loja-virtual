package br.com.lojavirtual.service.security;

import br.com.lojavirtual.entity.user.User;
import br.com.lojavirtual.repository.user.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

  @Autowired
  private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    Optional<User> user = repository.findByName(name);
    if(user.isPresent()) {
      return user.get();
    }
    throw new UsernameNotFoundException("User or password invalid") ;
  }
}
