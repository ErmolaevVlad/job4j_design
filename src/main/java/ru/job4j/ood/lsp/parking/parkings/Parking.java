package ru.job4j.ood.lsp.parking.parkings;

import ru.job4j.ood.lsp.parking.cars.Car;

import java.util.List;
import java.util.Map;

public interface Parking {

    void parkCar(List<Car> carList);

    Map<Integer, Boolean[]> getParking();

    int getFreePlace();
}
