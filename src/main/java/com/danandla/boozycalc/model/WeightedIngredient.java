package com.danandla.boozycalc.model;

import javax.persistence.Embeddable;

@Embeddable
public class WeightedIngredient {
    Long ingredientId;
    float amount;

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "WeightedIngredient{" +
                "ingredientId=" + ingredientId +
                ", amount=" + amount +
                '}';
    }
}
