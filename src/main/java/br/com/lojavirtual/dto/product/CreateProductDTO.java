package br.com.lojavirtual.dto.product;

import br.com.lojavirtual.entity.product.Product;
import javax.validation.constraints.NotNull;
import lombok.Data;

public @Data
class CreateProductDTO {

  @NotNull
  private String name;

  private String description;

  @NotNull
  private double price;

  private double initialStorage;

  public Product createProduct() {
    return new Product(null, this.name, this.price, this.description);
  }
}
