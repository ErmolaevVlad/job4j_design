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

    /**
     * Нарушение принципа SRP, так как класс содержит
     * метод для получения зарегистрироанного номера для выставки
     * @param dog
     * @return RegisteredNumber registered number for participation in the exhibition
     */
    public RegisteredNumber registrationForCompetition(Dog dog) {
        return new RegisteredNumber(dog);
    }
}
