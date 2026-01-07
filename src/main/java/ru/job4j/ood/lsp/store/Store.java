package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.products.Food;

import java.util.List;

public interface Store {

    void addProductToStore(Food food);

    List<Food> getAllProductFromStore();

    void takeProductForSore(List<Food> foodList);
}