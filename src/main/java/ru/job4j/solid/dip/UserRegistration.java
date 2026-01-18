package ru.job4j.solid.dip;

public class UserRegistration {
    /**
     * Зависимость от конкретного класса, а не от абстракции
     */

    private MySQLDB database = new MySQLDB();

    public void rester(String user) {
        database.save(user);
    }
}
