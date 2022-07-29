package com.danandla.boozycalc.repository;

import com.danandla.boozycalc.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<ProductEntity, Long> {
    @Query(value = "SELECT * FROM products WHERE NAME = ?1", nativeQuery = true)
    ProductEntity findByName(String name);

    @Query(value = "SELECT * FROM products WHERE ingr_id = ?1", nativeQuery = true)
    List<ProductEntity> findByIngrId(Long id);
}
