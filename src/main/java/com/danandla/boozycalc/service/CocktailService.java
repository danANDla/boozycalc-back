package com.danandla.boozycalc.service;

import com.danandla.boozycalc.entity.CocktailEntity;
import com.danandla.boozycalc.entity.IngredientEntity;
import com.danandla.boozycalc.exception.ItemIdNotFoundException;
import com.danandla.boozycalc.exception.ItemNameNotFoundException;
import com.danandla.boozycalc.exception.ItemNameUsedException;
import com.danandla.boozycalc.model.WeightedIngredient;
import com.danandla.boozycalc.repository.CocktailRepo;
import com.danandla.boozycalc.repository.IngrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CocktailService {

    @Autowired
    private CocktailRepo cocktailRepo;

    @Autowired
    private IngrRepo ingrRepo;

    public CocktailEntity addCocktail(CocktailEntity newCocktail) throws ItemNameUsedException, ItemIdNotFoundException {
        if (cocktailRepo.findByName(newCocktail.getName()) != null)
            throw new ItemNameUsedException("cocktail with this name already exists");
        for (WeightedIngredient i:
             newCocktail.getIngredients()) {
            if(ingrRepo.findById(i.getIngredientId()).isEmpty()) throw new ItemIdNotFoundException("ingredient with this id was not found");
        }
        return cocktailRepo.save(newCocktail);
    }

    public List<CocktailEntity> getAllCocktails() {
        List<CocktailEntity> list = (List<CocktailEntity>) cocktailRepo.findAll();
        return list;
    }

    public Long deleteCocktailByName(String cocktailName) throws ItemNameNotFoundException {
        CocktailEntity t = cocktailRepo.findByName(cocktailName);
        if (t != null) {
            Long id = t.getId();
            cocktailRepo.deleteById(id);
            return id;
        }
        else throw new ItemNameNotFoundException("cocktail with this name wasn't found");
    }

    public Long deleteById(Long cocktailId) throws ItemNameNotFoundException {
        CocktailEntity t = cocktailRepo.findById(cocktailId).get();
        if (t != null) {
            cocktailRepo.deleteById(cocktailId);
            return cocktailId;
        }
        else throw new ItemNameNotFoundException("cocktail with this id wasn't found");
    }
}
