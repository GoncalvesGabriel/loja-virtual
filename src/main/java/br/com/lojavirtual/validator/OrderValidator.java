package br.com.lojavirtual.validator;

import br.com.lojavirtual.entity.order.Order;
import br.com.lojavirtual.entity.order.OrderItem;
import br.com.lojavirtual.service.product.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator implements Validator<Order> {

  @Autowired
  private StorageService storageService;

  @Override
  public void validate(Order order) {
    order.getItens().stream().forEach(this::validateContainsStorage);
  }

  private void validateContainsStorage(OrderItem item) {
    double quantity = storageService.findQuantityByProduct(item.getProduct());
    if (item.getQuantity() > quantity) {
      throw new RuntimeException(String.format("Storage of the product %s unavailable", item.getProductName()));
    }
  }
}
