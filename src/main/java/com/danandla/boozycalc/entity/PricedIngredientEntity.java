package com.danandla.boozycalc.entity;

import javax.persistence.*;

@Entity
@Table(name = "pricedIngredients")
public class PricedIngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String product_name;
    private String product_description;
    private float product_price;
    private String product_ref;

    @ManyToOne
    @JoinColumn(name = "ingr_id")
    private IngredientEntity globalIngredient;

    public PricedIngredientEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    public String getProduct_ref() {
        return product_ref;
    }

    public void setProduct_ref(String product_ref) {
        this.product_ref = product_ref;
    }

    public IngredientEntity getGlobalIngredient() {
        return globalIngredient;
    }

    public void setGlobalIngredient(IngredientEntity globalIngredient) {
        this.globalIngredient = globalIngredient;
    }
}
