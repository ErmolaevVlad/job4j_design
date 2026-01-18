package ru.job4j.solid.dip;

import java.io.FileOutputStream;
import java.io.IOException;

public class ReportSaver {

    public void save(String report) {
        /**
         * Зависимость от конкретной реализации файлового вывода.
         * Может не работать на другой ОС, где нет диска С.
         */
        try (FileOutputStream output = new FileOutputStream("C:/reports/report.txt")) {
            output.write(report.getBytes());
            output.write(System.lineSeparator().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
