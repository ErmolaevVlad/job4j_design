package ru.job4j.ood.lsp.parking.control;

import org.junit.jupiter.api.Test;

import ru.job4j.ood.lsp.parking.cars.Car;
import ru.job4j.ood.lsp.parking.cars.PassengerCar;
import ru.job4j.ood.lsp.parking.cars.Truck;
import ru.job4j.ood.lsp.parking.parkings.FirstParking;
import ru.job4j.ood.lsp.parking.parkings.Parking;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ControlParkinTest {

    @Test
    void whenOnePassengerCarAndOneTrukCarThenParkThemInTheirPlaces() {
        Map<Integer, Boolean[]> map = new HashMap<>();
        Boolean[] array = new Boolean[9];
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

        ControlParkin controlParkin = new ControlParkin(parkingList);
        controlParkin.chekFreePlaces(carList);
        int expectedFreePlaces = 10;
        assertThat(carList).isEmpty();
        assertThat(firstParking.getFreePlace()).isEqualTo(expectedFreePlaces);
    }

    @Test
    void whenParkCarThemInTheirPlacesAndPlaceForTrukFullThenTrukParcInPlaceOfPassengerCar() {
        Map<Integer, Boolean[]> map = new HashMap<>();
        Boolean[] array = new Boolean[9];
        Arrays.fill(array, true);
        Boolean[] array1 = new Boolean[3];
        Arrays.fill(array1, true);
        map.put(1, array);
        map.put(2, array1);
        Parking firstParking = new FirstParking(map);
        List<Parking> parkingList = new ArrayList<>();
        parkingList.add(firstParking);

        Car pasCar = new PassengerCar(1);
        Car pasCar1 = new PassengerCar(1);
        Car trukCar = new Truck(2);
        Car trukCar1 = new Truck(2);
        Car trukCar2 = new Truck(2);
        Car trukCar3 = new Truck(2);

        List<Car> carList = new ArrayList<>();
        carList.add(pasCar);
        carList.add(pasCar1);
        carList.add(trukCar);
        carList.add(trukCar1);
        carList.add(trukCar2);
        carList.add(trukCar3);

        ControlParkin controlParkin = new ControlParkin(parkingList);
        controlParkin.chekFreePlaces(carList);
        int expectedFreePlaces = 5;
        assertThat(carList).isEmpty();
        assertThat(firstParking.getFreePlace()).isEqualTo(expectedFreePlaces);
    }

    @Test
    void whenPlacesPassengerCarFullThenNotParkNewPassengerCar() {
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
        Car pasCar1 = new PassengerCar(1);
        Car pasCar2 = new PassengerCar(1);
        Car trukCar = new Truck(2);

        List<Car> carList = new ArrayList<>();
        carList.add(pasCar);
        carList.add(pasCar1);
        carList.add(pasCar2);
        carList.add(trukCar);

        ControlParkin controlParkin = new ControlParkin(parkingList);
        controlParkin.chekFreePlaces(carList);

        Car pasCar3 = new PassengerCar(1);
        List<Car> carListNew = new ArrayList<>();
        carListNew.add(pasCar3);

        controlParkin.chekFreePlaces(carListNew);
        int expectedFreePlaces = 2;
        assertThat(carListNew).isNotEmpty()
                .hasSize(1);
        assertThat(firstParking.getFreePlace()).isEqualTo(expectedFreePlaces);
    }

    @Test
    void whenParkingFullThenNotParkNewCar() {
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
        Car pasCar1 = new PassengerCar(1);
        Car pasCar2 = new PassengerCar(1);
        Car trukCar = new Truck(2);

        List<Car> carList = new ArrayList<>();
        carList.add(pasCar);
        carList.add(pasCar1);
        carList.add(pasCar2);
        carList.add(trukCar);

        ControlParkin controlParkin = new ControlParkin(parkingList);
        controlParkin.chekFreePlaces(carList);

        Car pasCar3 = new PassengerCar(1);
        Car trukCar2 = new Truck(2);
        List<Car> carListNew = new ArrayList<>();
        carListNew.add(pasCar3);
        carListNew.add(trukCar2);

        controlParkin.chekFreePlaces(carListNew);
        int expectedFreePlaces = 0;
        assertThat(carListNew).isNotEmpty()
                .hasSize(2);
        assertThat(firstParking.getFreePlace()).isEqualTo(expectedFreePlaces);
    }
}