package com.danandla.boozycalc.entity;

import com.danandla.boozycalc.model.WeightedIngredient;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cocktails")
public class CocktailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String description;
    @ElementCollection
    private List<WeightedIngredient> ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WeightedIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<WeightedIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
