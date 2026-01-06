package ru.job4j.ood.lsp.discount;

import ru.job4j.ood.lsp.products.Food;

public interface CalculateDiscount {

    double calculateNewPrice(Food food);
}
