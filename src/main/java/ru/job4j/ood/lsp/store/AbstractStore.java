package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.products.Food;

import java.util.List;

public abstract class AbstractStore implements Store {

    private List<Food> foods;

    public AbstractStore(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public void addProductToStore(Food food) {
        foods.add(food);
    }

    @Override
    public List<Food> getAllProductFromStore() {
        return foods;
    }
}