package br.com.lojavirtual.dto.product;

import br.com.lojavirtual.entity.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
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
}
