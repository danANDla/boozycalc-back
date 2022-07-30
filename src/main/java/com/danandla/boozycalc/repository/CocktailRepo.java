package com.danandla.boozycalc.repository;

import com.danandla.boozycalc.entity.CocktailEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CocktailRepo extends CrudRepository<CocktailEntity, Long> {
    @Query(value = "SELECT * FROM cocktails WHERE NAME = ?1", nativeQuery = true)
    CocktailEntity findByName(String name);
}
