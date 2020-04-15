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
  private StorageService storageService;

  public ProductDTO create(CreateProductDTO productDTO) {
    Product product = productDTO.createProduct();
    repository.save(product);
    storageService.create(product, productDTO.getInitialStorage());
    return new ProductDTO(product);
  }

  public void delete(Long id) {
      storageService.deleteByProductId(id);
      repository.deleteById(id);
  }

  public List<ProductDTO> find() {
    return repository.findAllDTO();
  }

  public Product findEntityById(Long id) {
    Optional<Product> productOp = repository.findById(id);
    if (productOp.isPresent()) {
      return productOp.get();
    }
    throw new RuntimeException("Product not found");
  }

  public Optional<ProductDTO> findById(Long id) {
    Optional<Product> productOp = repository.findById(id);
    if (productOp.isPresent()) {
      return Optional.of(new ProductDTO(productOp.get()));
    }
    return Optional.empty();
  }
}
