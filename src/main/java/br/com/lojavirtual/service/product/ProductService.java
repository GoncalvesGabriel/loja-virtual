package br.com.lojavirtual.service.product;

import br.com.lojavirtual.dto.product.CreateProductDTO;
import br.com.lojavirtual.dto.product.ProductDTO;
import br.com.lojavirtual.entity.product.Product;
import br.com.lojavirtual.repository.product.ProductRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

  @Autowired
  private ProductRepository repository;

  @Autowired
  private StorageService service;

  public ProductDTO create(CreateProductDTO productDTO) {
    Product product = productDTO.createProduct();
    repository.save(product);
    service.create(product, productDTO.getInitialStorage());
    return new ProductDTO(product);
  }

  public void delete(Long id) {
      repository.deleteById(id);
  }

  public List<ProductDTO> findBy() {
    return repository.findAllDTO();
  }

  public Optional<ProductDTO> findById(Long id) {
    Optional<Product> productOp = repository.findById(id);
    if (productOp.isPresent()) {
      return Optional.of(new ProductDTO(productOp.get()));
    }
    return Optional.empty();
  }
}
