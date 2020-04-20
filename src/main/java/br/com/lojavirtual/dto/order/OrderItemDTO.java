package br.com.lojavirtual.dto.order;

import br.com.lojavirtual.entity.order.OrderItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data
class OrderItemDTO {

  @ApiModelProperty(value = "Nome do produto contido no pedido")
  private String product;

  @ApiModelProperty(value = "Quantidade comprada do produto")
  private double quantity;

  public OrderItemDTO(OrderItem item) {
    this.product = item.getProduct().getName();
    this.quantity = item.getQuantity();
  }
}
