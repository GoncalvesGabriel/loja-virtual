package br.com.lojavirtual.repository.product;

import br.com.lojavirtual.entity.product.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StorageRepository extends JpaRepository<Storage, Long> {

  @Modifying
  @Query("DELETE FROM Storage storage WHERE storage.product.id = :productId")
  void deleteByProductId(@Param("productId")Long productId);

  @Query("Select storage.quantityInStorage FROM Storage storage WHERE storage.product.id = :productId")
  double findQuantityByProductId(@Param("productId")Long productId);
}
