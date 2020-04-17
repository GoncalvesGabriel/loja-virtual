package br.com.lojavirtual.controller;

import static br.com.lojavirtual.TestHelper.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.lojavirtual.dto.order.CreateOrderDTO;
import br.com.lojavirtual.dto.order.CreateOrderItemDTO;
import br.com.lojavirtual.dto.order.OrderDTO;
import br.com.lojavirtual.service.order.OrderService;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderControllerTest {

  private MockMvc mockMvc;

  @Mock
  private OrderService service;

  @InjectMocks
  private OrderController controller;

  @Before
  public void setup() throws Exception {
    this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    OrderDTO teste = OrderDTO.builder().user("Teste").itens(new ArrayList<>()).build();
    Mockito.when(service.createOrder(ArgumentMatchers.any(CreateOrderDTO.class))).thenReturn(teste);
  }

  @Test
  public void create() throws Exception {
    CreateOrderItemDTO itemDTO =  new CreateOrderItemDTO(1L, 20);
    ArrayList<CreateOrderItemDTO> dtos = new ArrayList<>();
    dtos.add(itemDTO);
    mockMvc.perform(MockMvcRequestBuilders
        .post("/orders")
        .content(asJsonString(new CreateOrderDTO(dtos)))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.user").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.itens").exists());
  }
}