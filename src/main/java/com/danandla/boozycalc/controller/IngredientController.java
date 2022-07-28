package com.danandla.boozycalc.controller;

import com.danandla.boozycalc.entity.IngredientEntity;
import com.danandla.boozycalc.exception.IngredientNameNotFoundException;
import com.danandla.boozycalc.exception.IngredientNameUsedException;
import com.danandla.boozycalc.repository.IngrRepo;
import com.danandla.boozycalc.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/all")
    public ResponseEntity getIngredients() {
        try {
            return ResponseEntity.ok(ingredientService.getAllIngredients());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addIngredient(@RequestBody IngredientEntity newIngredient) {
        try {
            ingredientService.addIngredient(newIngredient);
            return ResponseEntity.ok("ingredient successfully added");
        } catch (IngredientNameUsedException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping
    public ResponseEntity getIngredientByName(@RequestParam String ingredientName) {
        try {
            return ResponseEntity.ok(ingredientService.findIngredientByName(ingredientName));
        } catch (IngredientNameNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
