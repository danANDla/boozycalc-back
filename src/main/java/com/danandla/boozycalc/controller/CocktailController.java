package com.danandla.boozycalc.controller;

import com.danandla.boozycalc.entity.CocktailEntity;
import com.danandla.boozycalc.exception.ItemIdNotFoundException;
import com.danandla.boozycalc.exception.ItemNameUsedException;
import com.danandla.boozycalc.model.WeightedIngredient;
import com.danandla.boozycalc.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cocktails")
public class CocktailController {

    @Autowired
    private CocktailService cocktailService;

    @GetMapping("/all")
    public ResponseEntity getCocktails() {
        try {
            return ResponseEntity.ok(cocktailService.getAllCocktails());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addCocktail(@RequestBody CocktailEntity newCocktail) {
        try {
            cocktailService.addCocktail(newCocktail);
            return ResponseEntity.ok("cocktail successfully added");
        } catch (ItemNameUsedException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ItemIdNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
