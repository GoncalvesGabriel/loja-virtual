package br.com.lojavirtual.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "STORAGE")
public @Data class Storage {

  @Id
  @Column(name = "STORAGE_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "PRODUCT_ID")
  private Product product;

  @Column(name = "QUANTITY_STORAGE")
  private double quantityInSTORAGE;

  @Column(name = "QUANTITY_RESERVE")
  private double quantityInReserve;

  public Storage(Product product, double quantityInSTORAGE) {
    this.product = product;
    this.quantityInSTORAGE = quantityInSTORAGE;
    this.quantityInReserve = 0;
  }
}
