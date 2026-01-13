package ru.job4j.ood.lsp.parking.parkings;

import ru.job4j.ood.lsp.parking.cars.Car;

import java.util.List;
import java.util.Map;

public class FirstParking extends AbstractParking {
    public FirstParking(Map<Integer, Boolean[]> map) {
        super(map);
    }

    @Override
    public void parkCar(List<Car> carList) {
        Map<Integer, Boolean[]> parking = this.getParking();
        carList.removeIf(car -> {
            boolean chek = false;
                Boolean[] places = parking.get(car.getSize());
                    for (int index = 0; index < places.length; index++) {
                        if (places[index]) {
                            places[index] = false;
                            this.setFreePlaces(1);
                            chek = true;
                            break;
                        }
                    }
                if (!chek && car.getSize() != MIN_SIZE_PLACE) {
                    places = parking.get(MIN_SIZE_PLACE);
                    int countFreePlace = 0;
                    for (int index = 0; index < places.length; index++) {
                        if (places[index]) {
                            countFreePlace++;
                            if (countFreePlace == car.getSize()) {
                                this.setFreePlaces(countFreePlace);
                                for (int i = index; countFreePlace > 0; countFreePlace--) {
                                    places[i] = false;
                                    i--;
                                }
                                chek = true;
                                break;
                            }
                        }

                    }
                }
            return chek;
        });
    }
}
