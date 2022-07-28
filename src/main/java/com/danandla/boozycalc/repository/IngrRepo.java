package com.danandla.boozycalc.repository;

import com.danandla.boozycalc.entity.IngredientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IngrRepo extends CrudRepository <IngredientEntity, Long> {
    @Query(value = "SELECT * FROM INGREDIENTS WHERE NAME = ?1", nativeQuery = true)
    IngredientEntity findByName(String name);
}
