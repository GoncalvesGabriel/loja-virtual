package br.com.lojavirtual.entity.order;


import br.com.lojavirtual.entity.user.User;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "ORDERSHIP")
public @Data
class Order {

  @Id
  @Column(name = "ORDERSHIP_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "USER_ID")
  private User user;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
  private Set<OrderItem> itens = new HashSet<>();

  public Order(User user) {
    this.user = user;
  }

  public void additem(OrderItem item) {
      this.itens.add(item);
  }

  public void removeItem(OrderItem item){
    this.itens.remove(item);
  }
}
