package ru.job4j.solid.srp;

public class Dog {

    private String name;
    private String breed;

    public Dog(String breed, String name) {
        this.breed = breed;
        this.name = name;
    }

    public void bark() {
        System.out.println("Auf");
    }

    public RegisteredNumber registrationForCompetition(Dog dog) {
        return new RegisteredNumber(dog);
    }
}
