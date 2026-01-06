package ru.job4j.ood.lsp.products;

import java.time.LocalDateTime;

public class Food {
    private String name;
    private LocalDateTime expiryDate;
    private LocalDateTime createDate;
    private double price;
    private int discount;

    public Food(String name, LocalDateTime createDate, LocalDateTime expiryDate, double price, int discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
