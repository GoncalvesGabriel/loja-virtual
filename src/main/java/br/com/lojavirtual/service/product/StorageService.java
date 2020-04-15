package br.com.lojavirtual.service.product;

import br.com.lojavirtual.entity.product.Product;
import br.com.lojavirtual.entity.product.Storage;
import br.com.lojavirtual.repository.product.StorageRepository;
import io.swagger.annotations.Api;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StorageService {

  @Autowired
  private StorageRepository repository;

  public void create(Product product, double initialQuantity) {
    Storage storage = new Storage(product, initialQuantity);
    repository.save(storage);
  }

}
