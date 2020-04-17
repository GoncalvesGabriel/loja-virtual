package br.com.lojavirtual.dto.order;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data
class CreateOrderDTO {

  private List<CreateOrderItemDTO> itens;

}
