package br.com.lojavirtual.service.order;

import br.com.lojavirtual.dto.order.CreateOrderDTO;
import br.com.lojavirtual.dto.order.OrderDTO;
import br.com.lojavirtual.dto.order.CreateOrderItemDTO;
import br.com.lojavirtual.entity.order.Order;
import br.com.lojavirtual.entity.order.OrderItem;
import br.com.lojavirtual.entity.product.Product;
import br.com.lojavirtual.entity.user.User;
import br.com.lojavirtual.repository.order.OrderRepository;
import br.com.lojavirtual.service.user.UserService;
import br.com.lojavirtual.service.product.ProductService;
import br.com.lojavirtual.validator.Validator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {

  @Autowired
  private Validator<Order> validator;

  @Autowired
  private OrderRepository repository;

  @Autowired
  private UserService userService;

  @Autowired
  private ProductService productService;

  public OrderDTO createOrder(CreateOrderDTO dto) {
    User user = userService.findById(1L);
    Order order = new Order(user);
    populateOrderItens(dto, order);
    validator.validate(order);
    repository.save(order);
    return new OrderDTO(order);
  }

  private void populateOrderItens(CreateOrderDTO dto, Order order) {
    Map<Long, OrderItem> itens = new HashMap<>();
    for (CreateOrderItemDTO item : dto.getItens()) {
      if (itens.containsKey(item.getProduct())) {
        OrderItem orderItem = itens.get(item.getProduct());
        orderItem.setQuantity(orderItem.getQuantity() + item.getQuantity());
      } else {
        OrderItem newItem = this.createItem(item);
        order.additem(newItem);
        itens.put(item.getProduct(), newItem);
      }
    }
  }

  private OrderItem createItem(CreateOrderItemDTO itemDto) {
    Product product = productService.findEntityById(itemDto.getProduct());
    return new OrderItem(product, itemDto.getQuantity());
  }

  public Optional<OrderDTO> findById(Long id) {
    Optional<Order> orderOp = repository.findById(id);
    if (orderOp.isPresent()) {
      return Optional.of(new OrderDTO(orderOp.get()));
    }
    return Optional.empty();
  }

  public List<OrderDTO> findAll() {
    return repository.findAllDTO();
  }
}
