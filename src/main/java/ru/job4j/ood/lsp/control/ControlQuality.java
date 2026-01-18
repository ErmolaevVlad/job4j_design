package ru.job4j.ood.lsp.control;

import ru.job4j.ood.lsp.products.Food;
import ru.job4j.ood.lsp.store.Store;


import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private final List<Store> stores;
    private final CalculateRemainingShelfLife calculateRemainingShelfLife;

    public ControlQuality(List<Store> stores, CalculateRemainingShelfLife calculateRemainingShelfLife) {
        this.stores = stores;
        this.calculateRemainingShelfLife = calculateRemainingShelfLife;
    }

    public void calcQuality(List<Food> foodList) {
        List<Food> foodListWithShelfLife = new ArrayList<>();
        for (Food food : foodList) {
            food.setRemainingShelfLife(calculateRemainingShelfLife.calcRemainingPercentageOfShelfLife(food));
            foodListWithShelfLife.add(food);
        }
        for (Store store : stores) {
            if (foodList.isEmpty()) {
                break;
            }
            store.takeProductForSore(foodListWithShelfLife);
        }
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (Store store : stores) {
            foods.addAll(store.getAllProductFromStore());
            store.getAllProductFromStore().clear();
        }
        calcQuality(foods);
    }
}