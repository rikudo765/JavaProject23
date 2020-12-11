package com.example.Project23.src;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Purchase {
    private final String name;
    private final int price;
    private final int count;

    @JsonCreator
    public Purchase(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
