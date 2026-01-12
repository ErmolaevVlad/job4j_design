package ru.job4j.ood.lsp.parking.cars;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PassengerCarTest {

    @Test
    void whenAddCarThenGetSizeOne() {
        Car passengerCar = new PassengerCar(1);
        int expectedSizeCar = 1;
        assertThat(passengerCar.getSize()).isEqualTo(expectedSizeCar);
    }

    @Test
    void whenAddPassengerCarWithSizeTwoThenException() {
        assertThatThrownBy(() -> new PassengerCar(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The size of the car must not be more than 1");
    }

    @Test
    void whenAddPassengerCarWithSizeMinusOneThenException() {
        assertThatThrownBy(() -> new PassengerCar(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The size of the car must be greater than 0");
    }
}