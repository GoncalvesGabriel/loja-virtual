package br.com.lojavirtual.controller;

import br.com.lojavirtual.dto.product.CreateProductDTO;
import br.com.lojavirtual.dto.product.ProductDTO;
import br.com.lojavirtual.service.product.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
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

@Api("Product API")
@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @ApiOperation(value = "Searches for a specific product by ID", consumes = "application/json", httpMethod = "GET")
  @ApiResponse(code = 200, message = "If product exist")
  @GetMapping(value = "/{id}", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ProductDTO> search(@PathVariable Long id) {
    Optional<ProductDTO> product = productService.findById(id);
    if (product.isPresent()) {
      return ResponseEntity.ok(product.get());
    }
    return ResponseEntity.notFound().build();
  }

  @ApiOperation(value = "Search all products", consumes = "application/json", httpMethod = "GET")
  @ApiResponse(code = 200, message = "Return a list with 0 or more products")
  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<ProductDTO> search() {
    return productService.findBy();
  }

  @ApiOperation(value = "Create new product", consumes = "application/json", httpMethod = "POST")
  @ApiResponse(code = 201, message = "Product successfully created")
  @PostMapping(consumes = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public ProductDTO create(@RequestBody CreateProductDTO productDTO) {
    return productService.create(productDTO);
  }
  @ApiOperation(value = "Delete one product with a specific id", httpMethod = "DELETE")
  @ApiResponse(code = 200, message = "Product successfully deleted")
  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable Long id) {
    productService.delete(id);
  }

}
