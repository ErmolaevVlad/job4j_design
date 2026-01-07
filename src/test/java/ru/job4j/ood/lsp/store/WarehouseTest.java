package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.control.CalculateRemainingShelfLife;
import ru.job4j.ood.lsp.products.Apple;
import ru.job4j.ood.lsp.products.Cakes;
import ru.job4j.ood.lsp.products.Food;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WarehouseTest {

    @Test
    void whenAddTwoProductsThenGetAllReturnListWithTwoProducts() {
        Store warehouse = new Warehouse();
        Food apple = new Apple("Gold", LocalDateTime.now().minusDays(3), LocalDateTime.now().plusDays(7), 300, 20);
        Food cake = new Cakes("Chocolate", LocalDateTime.now().minusDays(4), LocalDateTime.now().plusDays(7), 500, 20);
        warehouse.addProductToStore(apple);
        warehouse.addProductToStore(cake);
        List<Food> expectedListFood = new ArrayList<>();
        expectedListFood.add(apple);
        expectedListFood.add(cake);
        assertThat(warehouse.getAllProductFromStore()).isEqualTo(expectedListFood);
    }

    @Test
    void whenAddZeroProductThenGetAllReturnEmptyList() {
        Store warehouse = new Warehouse();
        assertThat(warehouse.getAllProductFromStore()).isEmpty();
    }

    @Test
    void whenListTwoProductsThenGetOneProductForWarehouse() {
        Store warehouse = new Warehouse();
        Food apple = new Apple("Gold", LocalDateTime.now().minusDays(4), LocalDateTime.now().plusDays(25), 300, 20);
        CalculateRemainingShelfLife calcRemainingShelfLife = new CalculateRemainingShelfLife();
        apple.setRemainingShelfLife(calcRemainingShelfLife.calcRemainingPercentageOfShelfLife(apple));
        Food cake = new Cakes("Chocolate", LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(3), 500, 20);
        cake.setRemainingShelfLife(calcRemainingShelfLife.calcRemainingPercentageOfShelfLife(cake));
        List<Food> foodList = new ArrayList<>();
        foodList.add(apple);
        foodList.add(cake);
        warehouse.takeProductForSore(foodList);
        List<Food> expectedListFood = new ArrayList<>();
        expectedListFood.add(apple);
        assertThat(warehouse.getAllProductFromStore()).isEqualTo(expectedListFood);
        assertThat(foodList).hasSize(1).containsExactlyInAnyOrder(cake);
    }
}