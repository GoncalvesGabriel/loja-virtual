package br.com.lojavirtual.repository.order;

import br.com.lojavirtual.dto.order.OrderDTO;
import br.com.lojavirtual.entity.order.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

  @Query("SELECT new br.com.lojavirtual.dto.order.OrderDTO(order) FROM Order order")
  public List<OrderDTO> findAllDTO();

}
