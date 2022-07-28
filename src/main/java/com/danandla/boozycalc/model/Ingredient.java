package com.danandla.boozycalc.model;

import com.danandla.boozycalc.entity.IngredientEntity;

public class Ingredient {
    private Long id;
    private String name;
    private String Description;

    public static Ingredient toModel(IngredientEntity entity) {
        Ingredient model = new Ingredient();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        return model;
    }

    public Ingredient() {
    }

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
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
