package br.com.lojavirtual.validator;

import br.com.lojavirtual.dto.user.CreateUserDTO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserValidatorTest {

  @InjectMocks
  private CreateUserValidator validator;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void failPasswordNotEquals() {
    CreateUserDTO userDTO = Mockito.mock(CreateUserDTO.class);
    Mockito.when(userDTO.getPassword()).thenReturn("passwordOne");
    Mockito.when(userDTO.getRePassword()).thenReturn("passwordTWO");

    thrown.expectMessage("Password and re-passowrd not are equals");

    validator.validate(userDTO);
  }

  @Test
  public void success() {
    CreateUserDTO userDTO = Mockito.mock(CreateUserDTO.class);
    Mockito.when(userDTO.getPassword()).thenReturn("passwordOne");
    Mockito.when(userDTO.getRePassword()).thenReturn("passwordOne");

    validator.validate(userDTO);
  }

}