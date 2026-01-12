package ru.job4j.ood.lsp.parking.cars;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TruckTest {

    @Test
    void whenAddCarWithSizeTwoThenGetSizeTwo() {
        Car truk = new Truck(2);
        int expectedSizeCar = 2;
        assertThat(truk.getSize()).isEqualTo(expectedSizeCar);
    }

    @Test
    void whenAddCarWithSizeTreeThenGetSizeTree() {
        Car truk = new Truck(3);
        int expectedSizeCar = 3;
        assertThat(truk.getSize()).isEqualTo(expectedSizeCar);
    }

    @Test
    void whenAddPassengerCarWithSizeFourThenException() {
        assertThatThrownBy(() -> new Truck(4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The size of the truck must be greater than 1 and less 4");
    }

    @Test
    void whenAddPassengerCarWithSizeOneThenException() {
        assertThatThrownBy(() -> new Truck(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The size of the truck must be greater than 1 and less 4");
    }

    @Test
    void whenAddPassengerCarWithSizeMinusOneThenException() {
        assertThatThrownBy(() -> new Truck(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The size of the truck must be greater than 1 and less 4");
    }
}