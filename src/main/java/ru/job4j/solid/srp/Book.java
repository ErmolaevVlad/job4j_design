package ru.job4j.solid.srp;

public class Book {

    private String name;
    private String author;
    int price;

    public Book(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    /**
     * Нарушение принципа SRP, так как класс сожержит
     * методы печати счета и сохранения счета в файл
     * @param invoice
     */
    public void printInvoice(Invoice invoice) {
        System.out.println(name + " " + price + "P" + " x " + invoice.getQuantity() + " = " + invoice.getSum());
    }

    public void saveToFile(String fileName, Invoice invoice) {
        System.out.println("invoice saved");
    }
}
