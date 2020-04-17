package br.com.lojavirtual.controller;

import static br.com.lojavirtual.TestHelper.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.lojavirtual.dto.product.CreateProductDTO;
import br.com.lojavirtual.dto.product.ProductDTO;
import br.com.lojavirtual.service.product.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class ProductControllerTest {

  private MockMvc mockMvc;

  @Mock
  private ProductService productService;

  @InjectMocks
  private ProductController controller;

  @Before
  public void setup() throws Exception {
    this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

  }

  @Test
  public void create() throws Exception {
    CreateProductDTO dto = new CreateProductDTO("Product test", "Product for test", 3000.0, 10);
    ProductDTO productDTO = ProductDTO.builder().id(1L).description(dto.getDescription()).price(dto.getPrice()).name(dto.getName()).build();
    Mockito.when(productService.create(dto)).thenReturn(productDTO);

    mockMvc.perform(MockMvcRequestBuilders
        .post("/products")
        .content(asJsonString(dto))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.description").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").exists());
  }
}