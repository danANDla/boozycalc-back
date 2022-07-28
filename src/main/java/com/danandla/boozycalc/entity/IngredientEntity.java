package com.danandla.boozycalc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingredients", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "globalIngredient")
    private List<PricedIngredientEntity> pricedIngredients;

    public IngredientEntity(){

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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
