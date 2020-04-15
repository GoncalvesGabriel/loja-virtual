package br.com.lojavirtual.dto.order;

import br.com.lojavirtual.entity.order.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data
class OrderItemDTO {

  private String product;

  private double quantity;

  public OrderItemDTO(OrderItem item) {
    this.product = item.getProduct().getName();
    this.quantity = item.getQuantity();
  }
}
