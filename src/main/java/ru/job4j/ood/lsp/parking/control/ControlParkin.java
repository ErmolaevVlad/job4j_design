package ru.job4j.ood.lsp.parking.control;

import ru.job4j.ood.lsp.parking.cars.Car;
import ru.job4j.ood.lsp.parking.parkings.Parking;

import java.util.ArrayList;
import java.util.List;

public class ControlParkin {
    private List<Parking> parkingList;

    public ControlParkin(List<Parking> parkingList) {
        this.parkingList = parkingList;
    }

    public void chekFreePlaces(List<Car> carList) {
        List<Parking> parkingListWithFreePlace = new ArrayList<>();
        for (Parking parking : parkingList) {
            if (parking.getFreePlace() > 0) {
                parkingListWithFreePlace.add(parking);
            }
        }
        for (Parking parking : parkingListWithFreePlace) {
            parking.parkCar(carList);
        }
    }
}
