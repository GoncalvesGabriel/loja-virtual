package br.com.lojavirtual.dto.order;


import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data
class CreateOrderDTO {

  @ApiModelProperty(value = "Lista de itens")
  private List<CreateOrderItemDTO> itens;

}
