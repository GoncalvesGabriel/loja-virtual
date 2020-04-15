package br.com.lojavirtual.entity.order;

import br.com.lojavirtual.entity.product.Product;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "ORDER_ITEM")
public @Data class OrderItem {

  @Id
  @Column(name = "ORDER_ITEM_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "PRODUCT_ID")
  private Product product;

  @Column(name = "QUANTITY")
  private double quantity;

  @ManyToOne
  @JoinColumn(name = "ORDER_ID")
  private Order order;

  public OrderItem(Product product, double quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  @Transient
  public String getProductName() {
    return getProduct().getName();
  }
}
