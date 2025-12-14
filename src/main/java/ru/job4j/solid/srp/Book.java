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

    public void printInvoice(Invoice invoice) {
        System.out.println(name + " " + price + "P" + " x " + invoice.getQuantity() + " = " + invoice.getSum());
    }

    public void saveToFile(String fileName) {
        System.out.println("invoice saved");
    }
}
