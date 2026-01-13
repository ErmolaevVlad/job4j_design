package ru.job4j.solid.isp;

public interface SmartWatch {

    void pulse();

    /**
     * Функция пульса имеется практически во всех смарт-часах,
     * то экг это премиум-функция, доступная в дорогих моделях
     */
    void ecg();
}
