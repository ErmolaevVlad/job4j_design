package ru.job4j.solid.lsp;

public class Dog {
    int walkingTime;

    public Dog(int walkingTime) {
        this.walkingTime = walkingTime;
    }

    public boolean checkWalkingTime(int walkingTime) {
        int averageWalkingTime = 60;
        if (walkingTime < averageWalkingTime) {
            throw new IllegalArgumentException("the number of minutes on a walk should be at least 60");
        }
        return true;
    }
}

class Chihuahua extends Dog {

    public Chihuahua(int walkingTime) {
        super(walkingTime);
    }

    /**
     * Происходит ослабление предусловия.
     * Маленькие породы собак не требуют долгих прогулок
     * @param walkingTime
     * @return true, если время прогулки удовлетворяет среднему
     */
    public boolean checkWalkingTime(int walkingTime) {
        int averageWalkingTime = 30;
        if (walkingTime < averageWalkingTime) {
            throw new IllegalArgumentException("the number of minutes on a walk should be at least 30");
        }
        return true;
    }
}