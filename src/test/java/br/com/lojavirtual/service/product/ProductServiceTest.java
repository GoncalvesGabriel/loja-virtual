package br.com.lojavirtual.service.product;

import br.com.lojavirtual.dto.product.CreateProductDTO;
import br.com.lojavirtual.entity.product.Product;
import br.com.lojavirtual.repository.product.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

  @Mock
  private ProductRepository productRepository;

  @Mock
  private StorageService storageService;

  @InjectMocks
  private ProductService service;

  @Test
  public void createSuccess() {
    CreateProductDTO dto = Mockito.mock(CreateProductDTO.class);
    Product product = new Product();
    double initialStorage = 1000D;

    Mockito.when(dto.createProduct()).thenReturn(product);
    Mockito.when(dto.getInitialStorage()).thenReturn(initialStorage);

    service.create(dto);

    Mockito.verify(productRepository, Mockito.times(1)).save(product);
    Mockito.verify(storageService, Mockito.times(1)).create(product, initialStorage);
  }

}