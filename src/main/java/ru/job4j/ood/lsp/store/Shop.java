package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.discount.CalculateNewPriceFood;
import ru.job4j.ood.lsp.products.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {
    public Shop() {
        super(new ArrayList<>());
    }

    @Override
    public void takeProductForSore(List<Food> foodList) {
        foodList.removeIf(food -> {
            if (food.getRemainingShelfLife() >= SHOP_QUALITY && food.getRemainingShelfLife() < SHOP_QUALITY_DISCOUNT) {
                addProductToStore(food);
                return true;
            } else if (food.getRemainingShelfLife() >= SHOP_QUALITY_DISCOUNT && food.getRemainingShelfLife() < TRASH_QUALITY) {
                CalculateNewPriceFood newPriceFood = new CalculateNewPriceFood();
                food.setPrice(newPriceFood.calculateNewPrice(food));
                addProductToStore(food);
                return true;
            }
            return false;
        });
    }
}