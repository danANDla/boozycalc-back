package com.danandla.boozycalc.entity;

import javax.persistence.*;

@Entity
@Table(name = "products", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String description;
    private float price;
    private String ref;

    @ManyToOne
    @JoinColumn(name = "ingr_id")
    private IngredientEntity globalIngredient;

    public ProductEntity() {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public IngredientEntity getGlobalIngredient() {
        return globalIngredient;
    }

    public void setGlobalIngredient(IngredientEntity globalIngredient) {
        this.globalIngredient = globalIngredient;
    }
}
