package ru.job4j.ood.lsp.parking.cars;

public class Truck extends AbstractCar {
    public Truck(int size) {
        super(size);
    }

    @Override
    protected int checkSize(int size) {
        if (size <= 1 || size > 3) {
            throw new IllegalArgumentException("The size of the truck must be greater than 1 and less 4");
        }
        return size;
    }
}
