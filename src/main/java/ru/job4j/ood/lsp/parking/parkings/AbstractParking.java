package ru.job4j.ood.lsp.parking.parkings;

import java.util.Map;

public abstract class AbstractParking implements Parking {

    private Map<Integer, Boolean[]> parking;
    private int freePlaces;
    protected static final int MIN_SIZE_PLACE = 1;

    public AbstractParking(Map<Integer, Boolean[]> parking) {
        this.parking = parking;
        this.freePlaces = countingFreePlaces(parking);
    }

    @Override
    public Map<Integer, Boolean[]> getParking() {
        return parking;
    }

    @Override
    public int getFreePlace() {
        return freePlaces;
    }

    public void setFreePlaces(int freePlaces) {
        this.freePlaces = this.freePlaces - freePlaces;
    }

    private int countingFreePlaces(Map<Integer, Boolean[]> parking) {
        int countFreePlaces = 0;
        for (Integer key : parking.keySet()) {
            Boolean[] places = parking.get(key);
            countFreePlaces = countFreePlaces + places.length;
        }
        return countFreePlaces;
    }
}
