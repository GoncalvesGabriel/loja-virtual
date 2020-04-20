package br.com.lojavirtual.dto.order;

import br.com.lojavirtual.entity.order.Order;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data
class OrderDTO {

  @ApiModelProperty(value = "Nome do usuário que realizou o pedido")
  private String user;

  @ApiModelProperty(value = "Lista de itens")
  private List<OrderItemDTO> itens;

  public OrderDTO(Order order) {
      this.user = order.getUser().getName();
    itens = order.getItens().stream().map(OrderItemDTO::new).collect(Collectors.toList());
  }

  @Builder
  public OrderDTO(String user, List<OrderItemDTO> itens) {
    this.user = user;
    this.itens = itens;
  }
}
