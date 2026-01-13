package ru.job4j.ood.lsp.parking.cars;

public class AbstractCar implements Car {

    private int size;

    public AbstractCar(int size) {
        this.size = checkSize(size);
    }

    @Override
    public int getSize() {
        return size;
    }

    protected int checkSize(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("The size of the car must be greater than 0");
        }
        if (size > 1) {
            throw new IllegalArgumentException("The size of the car must not be more than 1");
        }
        return size;
    }
}
