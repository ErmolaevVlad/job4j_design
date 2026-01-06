package ru.job4j.ood.lsp.control;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.products.Apple;
import ru.job4j.ood.lsp.products.Cakes;
import ru.job4j.ood.lsp.products.Food;
import ru.job4j.ood.lsp.store.Shop;
import ru.job4j.ood.lsp.store.Store;
import ru.job4j.ood.lsp.store.Trash;
import ru.job4j.ood.lsp.store.Warehouse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    void whenAddTwoProductThenAddIntoWarehouse() {
       Store warehouse = new Warehouse();
       Store shop = new Shop();
       Store trash = new Trash();
       Food apple = new Apple("Gold", LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(7), 100, 20);
       Food cake = new Cakes("Chocolate", LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(7), 500, 20);
       List<Food> foodList = new ArrayList<>();
       foodList.add(apple);
       foodList.add(cake);
       Map<String, Store> storeMap = new HashMap<>();
       storeMap.put("warehouse", warehouse);
       storeMap.put("shop", shop);
       storeMap.put("trash", trash);
       ControlQuality controlQuality = new ControlQuality(storeMap);
       controlQuality.calcQuality(foodList);
       assertThat(warehouse.getAllProductFromStore())
               .hasSize(2)
               .containsExactlyInAnyOrder(apple, cake);
    }

   @Test
   void whenAddOneProductThenAddIntoShop() {
      Store warehouse = new Warehouse();
      Store shop = new Shop();
      Store trash = new Trash();
      Apple apple = new Apple("Gold", LocalDateTime.now().minusDays(4), LocalDateTime.now().plusDays(7), 100, 20);
      Food cake = new Cakes("Chocolate", LocalDateTime.now().minusDays(4), LocalDateTime.now().plusDays(7), 500, 20);
      List<Food> foodList = new ArrayList<>();
      foodList.add(apple);
      foodList.add(cake);
      Map<String, Store> storeMap = new HashMap<>();
      storeMap.put("warehouse", warehouse);
      storeMap.put("shop", shop);
      storeMap.put("trash", trash);
      ControlQuality controlQuality = new ControlQuality(storeMap);
      controlQuality.calcQuality(foodList);
      assertThat(shop.getAllProductFromStore())
              .hasSize(2)
              .containsExactlyInAnyOrder(apple, cake);
   }

   @Test
   void whenAddOneProductThenAddIntoShopWithNewPrice() {
      Store warehouse = new Warehouse();
      Store shop = new Shop();
      Store trash = new Trash();
      Apple apple = new Apple("Gold", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusDays(2), 100, 20);
      List<Food> foodList = new ArrayList<>();
      foodList.add(apple);
      double expectedPrice = apple.getPrice() * (double) (100 - apple.getDiscount()) / 100;
      Map<String, Store> storeMap = new HashMap<>();
      storeMap.put("warehouse", warehouse);
      storeMap.put("shop", shop);
      storeMap.put("trash", trash);
      ControlQuality controlQuality = new ControlQuality(storeMap);
      controlQuality.calcQuality(foodList);
      assertThat(shop.getAllProductFromStore().get(0).getPrice()).isEqualTo(expectedPrice);
   }

   @Test
   void whenAddTwoProductThenAddIntoTrash() {
      Store warehouse = new Warehouse();
      Store shop = new Shop();
      Store trash = new Trash();
      Apple apple = new Apple("Gold", LocalDateTime.now().minusDays(6), LocalDateTime.now().minusDays(1), 100, 20);
      Food cake = new Cakes("Chocolate", LocalDateTime.now().minusDays(4), LocalDateTime.now().minusDays(1), 500, 20);
      List<Food> foodList = new ArrayList<>();
      foodList.add(apple);
      foodList.add(cake);
      Map<String, Store> storeMap = new HashMap<>();
      storeMap.put("warehouse", warehouse);
      storeMap.put("shop", shop);
      storeMap.put("trash", trash);
      ControlQuality controlQuality = new ControlQuality(storeMap);
      controlQuality.calcQuality(foodList);
      assertThat(trash.getAllProductFromStore())
              .hasSize(2)
              .containsExactlyInAnyOrder(apple, cake);
   }

   @Test
   void whenAddTwoProductThenAddIntoTrashAndShop() {
      Store warehouse = new Warehouse();
      Store shop = new Shop();
      Store trash = new Trash();
      Apple apple = new Apple("Gold", LocalDateTime.now().minusDays(6), LocalDateTime.now().minusDays(1), 100, 20);
      Food cake = new Cakes("Chocolate", LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(6), 500, 20);
      List<Food> foodList = new ArrayList<>();
      foodList.add(apple);
      foodList.add(cake);
      Map<String, Store> storeMap = new HashMap<>();
      storeMap.put("warehouse", warehouse);
      storeMap.put("shop", shop);
      storeMap.put("trash", trash);
      ControlQuality controlQuality = new ControlQuality(storeMap);
      controlQuality.calcQuality(foodList);
      assertThat(trash.getAllProductFromStore())
              .hasSize(1)
              .containsExactlyInAnyOrder(apple);
      assertThat(shop.getAllProductFromStore())
              .hasSize(1)
              .containsExactlyInAnyOrder(cake);
   }
}