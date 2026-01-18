package ru.job4j.solid.dip;

public class ReportGeneration {
    private MySQLDB database;

    /**
     * зависимость от реализации MySQLDB, а не от абстракции
     * @param database
     */
    public ReportGeneration(MySQLDB database) {
        this.database = database;
    }
}
