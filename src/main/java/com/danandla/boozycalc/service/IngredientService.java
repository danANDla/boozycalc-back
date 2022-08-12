package com.danandla.boozycalc.service;

import com.danandla.boozycalc.entity.IngredientEntity;
import com.danandla.boozycalc.exception.ItemNameNotFoundException;
import com.danandla.boozycalc.exception.ItemNameUsedException;
import com.danandla.boozycalc.repository.IngrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IngredientService {

    @Autowired
    IngrRepo ingrRepo;

    public IngredientEntity addIngredient(IngredientEntity newIngredient) throws ItemNameUsedException {
        if (ingrRepo.findByName(newIngredient.getName()) != null)
            throw new ItemNameUsedException("ingredient with this name already exists");
        return ingrRepo.save(newIngredient);
    }

    public ArrayList<IngredientEntity> getAllIngredients() {
        ArrayList<IngredientEntity> list = (ArrayList<IngredientEntity>) ingrRepo.findAll();
        return list;
    }

    public IngredientEntity findIngredientByName(String ingredientName) throws ItemNameNotFoundException {
        IngredientEntity t = ingrRepo.findByName(ingredientName);
        if (t != null) return t;
        else throw new ItemNameNotFoundException("ingredient with this name wasn't found");
    }

    public Long deleteByName(String ingredientName) throws ItemNameNotFoundException {
        IngredientEntity t = ingrRepo.findByName(ingredientName);
        if (t != null) {
            Long id = t.getId();
            ingrRepo.deleteById(id);
            return id;
        }
        else throw new ItemNameNotFoundException("ingredient with this name wasn't found");
    }

    public Long deleteById(Long ingredientId) throws ItemNameNotFoundException {
        IngredientEntity t = ingrRepo.findById(ingredientId).get();
        if (t != null) {
            ingrRepo.deleteById(ingredientId);
            return ingredientId;
        }
        else throw new ItemNameNotFoundException("ingredient with this id wasn't found");
    }
}
