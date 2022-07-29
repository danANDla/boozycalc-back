package com.danandla.boozycalc.service;

import com.danandla.boozycalc.entity.IngredientEntity;
import com.danandla.boozycalc.entity.ProductEntity;
import com.danandla.boozycalc.exception.IngredientIdNotFoundException;
import com.danandla.boozycalc.exception.IngredientNameNotFoundException;
import com.danandla.boozycalc.exception.IngredientNameUsedException;
import com.danandla.boozycalc.model.Ingredient;
import com.danandla.boozycalc.repository.IngrRepo;
import com.danandla.boozycalc.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    IngrRepo ingrRepo;

    public ProductEntity addProduct(ProductEntity newProduct, Long ingr_id) throws IngredientNameUsedException, IngredientIdNotFoundException {
        if (productRepo.findByName(newProduct.getName()) != null)
            throw new IngredientNameUsedException("product with this name already exists");
        if(ingrRepo.findById(ingr_id).isEmpty()) throw new IngredientIdNotFoundException("ingredient with this id wasn't found");
        IngredientEntity ingr = ingrRepo.findById(ingr_id).get();
        newProduct.setGlobalIngredient(ingr);
        return productRepo.save(newProduct);
    }

    public ArrayList<ProductEntity> getAllProducts() {
        return (ArrayList<ProductEntity>) productRepo.findAll();
    }
}
