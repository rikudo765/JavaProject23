package com.example.Project23.src;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.IOException;
import java.util.ArrayList;

public class TableOfPurchases {
    private final ArrayList<Order> listOfOrders;

    @JsonCreator
    public TableOfPurchases(ArrayList<Order> listOfOrders) {
        this.listOfOrders = listOfOrders;
    }

    public static TableOfPurchases readTableOfPurchases(ArrayList<String> filenames) throws IOException {
        ArrayList<Order> orders = new ArrayList<>();
        for (String filename : filenames) {
            orders.add(Order.readFromFile(filename));
        }

        return new TableOfPurchases(orders);
    }

    public ArrayList<Order> getListOfOrders() {
        return listOfOrders;
    }
}

