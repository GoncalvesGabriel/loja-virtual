package br.com.lojavirtual.validator;

import static org.mockito.Mockito.when;

import br.com.lojavirtual.entity.order.Order;
import br.com.lojavirtual.entity.order.OrderItem;
import br.com.lojavirtual.entity.product.Product;
import br.com.lojavirtual.service.product.StorageService;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderValidatorTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Mock
  private StorageService service;

  @InjectMocks
  private OrderValidator validator;

  private OrderItem item;

  private Order order;

  @Before
  public void setup(){
    order = Mockito.mock(Order.class);
    item = Mockito.mock(OrderItem.class);
    Product product = Mockito.mock(Product.class);
    String productName = "New Product";

    when(order.getItens()).thenReturn(Collections.singleton(item));
    when(item.getProduct()).thenReturn(product);
    when(item.getProductName()).thenReturn(productName);
    when(service.findQuantityByProduct(product)).thenReturn(3D);
  }

  @Test
  public void failStorageWithoutQuantity() {
    when(item.getQuantity()).thenReturn(5D);
    thrown.expectMessage(String.format("Storage of the product %s unavailable", "New Product"));

    validator.validate(order);
  }

  @Test
  public void success() {
    when(item.getQuantity()).thenReturn(2D);

    validator.validate(order);
  }

}