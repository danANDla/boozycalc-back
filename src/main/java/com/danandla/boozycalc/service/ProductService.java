package com.danandla.boozycalc.service;

import com.danandla.boozycalc.entity.IngredientEntity;
import com.danandla.boozycalc.entity.ProductEntity;
import com.danandla.boozycalc.exception.ItemIdNotFoundException;
import com.danandla.boozycalc.exception.ItemNameNotFoundException;
import com.danandla.boozycalc.exception.ItemNameUsedException;
import com.danandla.boozycalc.repository.IngrRepo;
import com.danandla.boozycalc.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    IngrRepo ingrRepo;

    public ProductEntity addProduct(ProductEntity newProduct, Long ingr_id) throws ItemNameUsedException, ItemIdNotFoundException {
        if (productRepo.findByName(newProduct.getName()) != null)
            throw new ItemNameUsedException("product with this name already exists");
        if(ingrRepo.findById(ingr_id).isEmpty()) throw new ItemIdNotFoundException("ingredient with this id wasn't found");
        IngredientEntity ingr = ingrRepo.findById(ingr_id).get();
        newProduct.setGlobalIngredient(ingr);
        return productRepo.save(newProduct);
    }

    public ArrayList<ProductEntity> getAllProducts() {
        return (ArrayList<ProductEntity>) productRepo.findAll();
    }

    public List<ProductEntity> selectByIngredient(String ingredientName) throws ItemNameNotFoundException {
        IngredientEntity t = ingrRepo.findByName(ingredientName);
        if(t == null) throw new ItemNameNotFoundException("ingredient with name wasn't found");
        return productRepo.findByIngrId(t.getId());
    }
}
