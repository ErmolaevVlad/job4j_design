package ru.job4j.solid.isp;

import java.io.File;

public interface Writer {

    /**
     * Необходимы разные интерфейсы, под различные расширения.
     */

    void saveToXML(File file);

    void saveToTxt(File file);

    void saveToJson(File file);
}