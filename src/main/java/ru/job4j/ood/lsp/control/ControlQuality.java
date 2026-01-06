package ru.job4j.ood.lsp.control;

import ru.job4j.ood.lsp.discount.CalculateDiscount;
import ru.job4j.ood.lsp.discount.CalculateNewPriceFood;
import ru.job4j.ood.lsp.products.Food;
import ru.job4j.ood.lsp.store.Store;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

public class ControlQuality {

    private final Map<String, Store> storeMap;
    private final CalculateDiscount calculateDiscount;

    public ControlQuality(Map<String, Store> storeMap) {
        this.storeMap = storeMap;
        this.calculateDiscount = new CalculateNewPriceFood();
    }

    public void calcQuality(List<Food> foodList) {
        for (Food food : foodList) {
            long diff = calcRemainingPercentageOfShelfLife(food);
            if (inRange(diff, 0, 24)) {
                storeMap.get("warehouse").addProductToStore(food);
            }
            if (inRange(diff, 25, 75)) {
                storeMap.get("shop").addProductToStore(food);
            }
            if (inRange(diff, 75, 99)) {
                food.setPrice(calculateDiscount.calculateNewPrice(food));
                storeMap.get("shop").addProductToStore(food);
            }
            if (diff >= 100) {
                storeMap.get("trash").addProductToStore(food);
            }
        }
    }

    private boolean inRange(long num, long min, long max) {
        return num >= min && num <= max;
    }

    private long calcRemainingPercentageOfShelfLife(Food food) {
        long diff = ChronoUnit.SECONDS.between(food.getCreateDate(), LocalDateTime.now());
        long all = ChronoUnit.SECONDS.between(food.getCreateDate(), food.getExpiryDate());
        return Math.abs((diff * 100) / all);
    }
}