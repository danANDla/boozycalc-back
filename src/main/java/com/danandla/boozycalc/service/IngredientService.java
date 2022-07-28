package com.danandla.boozycalc.service;

import com.danandla.boozycalc.entity.IngredientEntity;
import com.danandla.boozycalc.exception.IngredientNameNotFoundException;
import com.danandla.boozycalc.exception.IngredientNameUsedException;
import com.danandla.boozycalc.repository.IngrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IngredientService {

    @Autowired
    IngrRepo ingrRepo;

    public IngredientEntity addIngredient(IngredientEntity newIngredient) throws IngredientNameUsedException{
        if (ingrRepo.findByName(newIngredient.getName()) != null)
            throw new IngredientNameUsedException("ingredient with this name already exists");
        return ingrRepo.save(newIngredient);
    }

    public ArrayList<IngredientEntity> getAllIngredients(){
        return (ArrayList<IngredientEntity>) ingrRepo.findAll();
    }

    public IngredientEntity findIngredientByName(String ingredientName) throws IngredientNameNotFoundException{
        IngredientEntity t = ingrRepo.findByName(ingredientName);
        if (t != null) return t;
        else throw new IngredientNameNotFoundException("ingredient with this name wasn't found");
    }
}
