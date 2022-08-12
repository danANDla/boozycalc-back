package com.danandla.boozycalc.controller;

import com.danandla.boozycalc.entity.CocktailEntity;
import com.danandla.boozycalc.exception.ItemIdNotFoundException;
import com.danandla.boozycalc.exception.ItemNameNotFoundException;
import com.danandla.boozycalc.exception.ItemNameUsedException;
import com.danandla.boozycalc.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cocktails")
public class CocktailController {

    @Autowired
    private CocktailService cocktailService;

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity getCocktails() {
        try {
            return ResponseEntity.ok(cocktailService.getAllCocktails());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:8081")
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

    @DeleteMapping
    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity deleteCocktailByName(@RequestParam String name) {
        try {
            return ResponseEntity.ok(cocktailService.deleteCocktailByName(name));
        } catch (ItemNameNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
