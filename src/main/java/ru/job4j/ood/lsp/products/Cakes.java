package ru.job4j.ood.lsp.products;

import java.time.LocalDateTime;

public class Cakes extends Food {
    public Cakes(String name, LocalDateTime createDate, LocalDateTime expiryDate, double price, int discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
