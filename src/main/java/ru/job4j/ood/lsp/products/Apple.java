package ru.job4j.ood.lsp.products;

import java.time.LocalDateTime;

public class Apple extends Food {
    public Apple(String name, LocalDateTime createDate, LocalDateTime expiryDate, double price, int discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}