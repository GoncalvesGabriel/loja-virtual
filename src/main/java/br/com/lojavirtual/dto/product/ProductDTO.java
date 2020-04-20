package br.com.lojavirtual.dto.product;

import br.com.lojavirtual.entity.product.Product;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public @Data
class ProductDTO {

  @ApiModelProperty(value = "Id do produto")
  private Long id;

  @ApiModelProperty(value = "Nome do produto")
  private String name;

  @ApiModelProperty(value = "Descrição do produto")
  private String description;

  @ApiModelProperty(value = "Preço da unidade do produto", example = "35,75")
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
