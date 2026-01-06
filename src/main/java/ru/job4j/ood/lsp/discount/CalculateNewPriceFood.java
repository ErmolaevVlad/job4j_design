package ru.job4j.ood.lsp.discount;

import ru.job4j.ood.lsp.products.Food;

public class CalculateNewPriceFood implements CalculateDiscount {

    @Override
    public double calculateNewPrice(Food food) {
        return food.getPrice() * (double) (100 - food.getDiscount()) / 100;
    }
}