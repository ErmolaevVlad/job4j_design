package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.products.Apple;
import ru.job4j.ood.lsp.products.Cakes;
import ru.job4j.ood.lsp.products.Food;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrashTest {

    @Test
    void whenAddTwoProductsThenGetAllReturnListWithTwoProducts() {
        Store trash = new Trash();
        Food apple = new Apple("Gold", LocalDateTime.now().minusDays(3), LocalDateTime.now().plusDays(7), 300, 20);
        Food cake = new Cakes("Chocolate", LocalDateTime.now().minusDays(4), LocalDateTime.now().plusDays(7), 500, 20);
        trash.addProductToStore(apple);
        trash.addProductToStore(cake);
        List<Food> expectedListFood = new ArrayList<>();
        expectedListFood.add(apple);
        expectedListFood.add(cake);
        assertThat(trash.getAllProductFromStore()).isEqualTo(expectedListFood);
    }

    @Test
    void whenAddZeroProductThenGetAllReturnEmptyList() {
        Store trash = new Trash();
        assertThat(trash.getAllProductFromStore()).isEmpty();
    }
}