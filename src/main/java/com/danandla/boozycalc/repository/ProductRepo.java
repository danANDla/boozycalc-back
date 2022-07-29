package com.danandla.boozycalc.repository;

import com.danandla.boozycalc.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<ProductEntity, Long> {
    @Query(value = "SELECT * FROM products WHERE NAME = ?1", nativeQuery = true)
    ProductEntity findByName(String name);
}
