package br.com.lojavirtual.controller;


import br.com.lojavirtual.dto.order.CreateOrderDTO;
import br.com.lojavirtual.dto.order.OrderDTO;
import br.com.lojavirtual.service.order.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/orders")
public class OrderController {

  @Autowired
  private OrderService service;

  @ApiOperation(value = "Do new order", consumes = "application/json", httpMethod = "POST")
  @ApiResponse(code = 201, message = "Order successfully placed")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OrderDTO create(CreateOrderDTO dto) {
      return service.createOrder(dto);
  }

  @ApiOperation(value = "Searches for a specific order by ID", consumes = "application/json", httpMethod = "GET")
  @ApiResponse(code = 200, message = "If order exist")
  @GetMapping("{id}")
  public ResponseEntity<OrderDTO> findOrder(@PathVariable Long id) {
    Optional<OrderDTO> orderOp =  service.findById(id);;
    if (orderOp.isPresent()) {
      return ResponseEntity.ok(orderOp.get());
    }
    return ResponseEntity.notFound().build();

  }

  @ApiOperation(value = "Search all orders", consumes = "application/json", httpMethod = "GET")
  @ApiResponse(code = 200, message = "Return a list with 0 or more orders")
  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<OrderDTO> search() {
    return service.findAll();
  }

}
