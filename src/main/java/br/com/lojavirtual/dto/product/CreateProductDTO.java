package br.com.lojavirtual.dto.product;

import br.com.lojavirtual.entity.product.Product;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data
class CreateProductDTO {

  @NotNull
  @ApiModelProperty(value = "Nome do produto")
  private String name;

  @ApiModelProperty(value = "Descrição do produto")
  private String description;

  @NotNull
  @ApiModelProperty(value = "Preço da unidade do produto", example = "35,75")
  private double price;

  @ApiModelProperty(value = "Quantidade inicial em estoque", example = "10,5")
  private double initialStorage;

  public Product createProduct() {
    return new Product(null, this.name, this.price, this.description);
  }
}
