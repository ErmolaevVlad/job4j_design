package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.products.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractStore {

    public Warehouse() {
        super(new ArrayList<>());
    }

    @Override
    public void takeProductForSore(List<Food> foodList) {
        foodList.removeIf(food -> {
            if (food.getRemainingShelfLife() < SHOP_QUALITY) {
                addProductToStore(food);
                return true;
            }
            return false;
        });
    }
}