package br.com.lojavirtual.controller;

import br.com.lojavirtual.dto.product.CreateProductDTO;
import br.com.lojavirtual.dto.product.ProductDTO;
import br.com.lojavirtual.service.product.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ProductDTO> search(@PathVariable Long id) {
    Optional<ProductDTO> product = productService.findById(id);
    if (product.isPresent()) {
      return ResponseEntity.ok(product.get());
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<ProductDTO> search() {
    return productService.findBy();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductDTO create(@RequestBody CreateProductDTO productDTO) {
    return productService.create(productDTO);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable Long id) {
    productService.delete(id);
  }

}
