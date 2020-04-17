package br.com.lojavirtual.dto.product;

import br.com.lojavirtual.entity.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public @Data
class ProductDTO {

  private Long id;

  private String name;

  private String description;

  private double price;

  public ProductDTO(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.description =  product.getDescription();
    this.price = product.getPrice();
  }

  @Builder
  public ProductDTO(Long id, String name, String description, double price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }
}
