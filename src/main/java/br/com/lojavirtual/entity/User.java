package br.com.lojavirtual.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "USER")
public @Data
class User {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "NAME")
  private String name;

  @Column(name =  "EMAIL", unique = true)
  private String email;

  @Column(name = "PASSOWORD")
  private String password;

}
