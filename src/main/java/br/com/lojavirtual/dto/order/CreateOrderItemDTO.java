package br.com.lojavirtual.dto.order;

import lombok.Data;

public @Data
class CreateOrderItemDTO {

  private Long product;

  private double quantity;

}
