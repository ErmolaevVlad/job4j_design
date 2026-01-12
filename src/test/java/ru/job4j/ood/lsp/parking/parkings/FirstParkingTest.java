package ru.job4j.ood.lsp.parking.parkings;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.cars.Car;
import ru.job4j.ood.lsp.parking.cars.PassengerCar;
import ru.job4j.ood.lsp.parking.cars.Truck;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class FirstParkingTest {

    @Test
    void whenAddTwoCarThenTwoCarPark() {
        Map<Integer, Boolean[]> map = new HashMap<>();
        Boolean[] array = new Boolean[3];
        Arrays.fill(array, true);
        Boolean[] array1 = new Boolean[3];
        Arrays.fill(array1, true);
        map.put(1, array);
        map.put(2, array1);
        Parking firstParking = new FirstParking(map);
        List<Parking> parkingList = new ArrayList<>();
        parkingList.add(firstParking);

        Car pasCar = new PassengerCar(1);
        Car trukCar = new Truck(2);

        List<Car> carList = new ArrayList<>();
        carList.add(pasCar);
        carList.add(trukCar);
        firstParking.parkCar(carList);
        int expectedFreePlaces = 4;
        assertThat(carList).isEmpty();
        assertThat(firstParking.getFreePlace()).isEqualTo(expectedFreePlaces);
    }

    @Test
    void whenTrukPlacesFullThenTruckCarInPlacePassengerCar() {
        Map<Integer, Boolean[]> map = new HashMap<>();
        Boolean[] array = new Boolean[3];
        Arrays.fill(array, true);
        Boolean[] array1 = new Boolean[1];
        Arrays.fill(array1, true);
        map.put(1, array);
        map.put(2, array1);
        Parking firstParking = new FirstParking(map);
        List<Parking> parkingList = new ArrayList<>();
        parkingList.add(firstParking);

        Car pasCar = new PassengerCar(1);
        Car trukCar = new Truck(2);

        List<Car> carList = new ArrayList<>();
        carList.add(pasCar);
        carList.add(trukCar);
        firstParking.parkCar(carList);

        Car trukCar1 = new Truck(2);
        List<Car> carListNew = new ArrayList<>();
        carListNew.add(trukCar1);
        firstParking.parkCar(carListNew);

        int expectedFreePlaces = 0;
        assertThat(carListNew).isEmpty();
        assertThat(firstParking.getFreePlace()).isEqualTo(expectedFreePlaces);
    }
}