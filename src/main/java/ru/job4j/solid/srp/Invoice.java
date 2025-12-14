package ru.job4j.solid.srp;

public class Invoice {

    private Book book;
    private int quantity;
    private double sum;

    public Invoice(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
        this.sum = calculateSum(book);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double calculateSum(Book book) {
        return book.price * quantity;
    }
}
