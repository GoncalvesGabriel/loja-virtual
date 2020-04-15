package br.com.lojavirtual.dto.order;


import java.util.List;
import lombok.Data;

public @Data
class CreateOrderDTO {

  private Long user;

  private List<CreateOrderItemDTO> itens;

}
