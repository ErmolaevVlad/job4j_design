package ru.job4j.ood.lsp.control;

import ru.job4j.ood.lsp.products.Food;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculateRemainingShelfLife {

    public Long calcRemainingPercentageOfShelfLife(Food food) {
        long diff = ChronoUnit.SECONDS.between(food.getCreateDate(), LocalDateTime.now());
        long all = ChronoUnit.SECONDS.between(food.getCreateDate(), food.getExpiryDate());
        return Math.abs((diff * 100) / all);
    }
}