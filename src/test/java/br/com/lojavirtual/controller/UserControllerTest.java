package br.com.lojavirtual.controller;

import static br.com.lojavirtual.TestHelper.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.lojavirtual.dto.user.CreateUserDTO;
import br.com.lojavirtual.dto.user.UserDTO;
import br.com.lojavirtual.service.user.UserService;
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
public class UserControllerTest {

  private MockMvc mockMvc;

  @Mock
  private UserService service;

  @InjectMocks
  private UserController controller;


  @Before
  public void setup() throws Exception {
    this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void create() throws Exception {
    CreateUserDTO userTest = new CreateUserDTO("UserTest", "userTeste@gmail.com", "teste@123", "teste@123");
    UserDTO userDTO = UserDTO.builder().id(1L).name(userTest.getName()).email(userTest.getEmail()).build();

    Mockito.when(service.create(userTest)).thenReturn(userDTO);
    mockMvc.perform(MockMvcRequestBuilders
        .post("/users")
        .content(asJsonString(userTest))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.email").exists());
  }


}
