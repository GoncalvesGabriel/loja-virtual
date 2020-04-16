package br.com.lojavirtual.entity.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USER_SYSTEM")
@NoArgsConstructor
@AllArgsConstructor
public @Data
class User  implements UserDetails {

  @Id
  @Column(name = "USER_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "NAME")
  private String name;

  @Column(name =  "EMAIL", unique = true)
  private String email;

  @Column(name = "PASSWORD")
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "ASSOC_USER_ROLE",
      joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
  private List<Role> roles = new ArrayList<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles;
  }

  @Transient
  @Override
  public String getUsername() {
    return name;
  }

  @Transient
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Transient
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Transient
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Transient
  @Override
  public boolean isEnabled() {
    return true;
  }

  public void addRole(Role userRole) {
    roles.add(userRole);
  }
}
