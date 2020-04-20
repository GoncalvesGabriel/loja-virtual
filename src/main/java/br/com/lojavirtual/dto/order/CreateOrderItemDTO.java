package br.com.lojavirtual.dto.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data
class CreateOrderItemDTO {

  @ApiModelProperty(value = "ID da produto")
  private Long product;

  @ApiModelProperty(value = "Quantidade do produto para a compra", example = "100,3")
  private double quantity;

}
