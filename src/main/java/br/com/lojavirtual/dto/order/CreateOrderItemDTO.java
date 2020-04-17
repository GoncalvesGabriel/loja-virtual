package br.com.lojavirtual.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data
class CreateOrderItemDTO {

  private Long product;

  private double quantity;

}
