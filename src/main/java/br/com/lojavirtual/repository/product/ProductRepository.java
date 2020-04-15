package br.com.lojavirtual.repository.product;

import br.com.lojavirtual.dto.product.ProductDTO;
import br.com.lojavirtual.entity.product.Product;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("SELECT new br.com.lojavirtual.dto.product.ProductDTO(prod.id, prod.name, prod.description, prod.price) from Product prod")
  public List<ProductDTO> findAllDTO();

}
