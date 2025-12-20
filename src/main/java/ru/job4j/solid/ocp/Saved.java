package ru.job4j.solid.ocp;

public class Saved {

    /**
     * Необходимо сохранять данные в БД
     */
    public void saveToDB() {
        System.out.println("saved to BD");
    }

    /**
     * Добавилась необходимость сохранения в файл.
     * Опять происходит изменение изменение из-за чего приходится дописывать код.
     */
    public void saveToFile() {
        System.out.println("saved to File");
    }
}
