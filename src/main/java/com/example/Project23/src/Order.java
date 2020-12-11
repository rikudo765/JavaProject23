package com.example.Project23.src;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Order {
    private final String clientName;
    private final ArrayList<Purchase> listOfPurchases;

    @JsonCreator
    public Order(String clientName, ArrayList<Purchase> listOfPurchases) {
        this.clientName = clientName;
        this.listOfPurchases = listOfPurchases;
    }

    public static Order readFromFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fileReader);

        ArrayList<Purchase> purchases = new ArrayList<>();

        String line = reader.readLine();
        String clientName = line;
        line = reader.readLine();
        while (line != null) {
            String[] args = line.split(" ");
            String name = args[0];
            int count = Integer.parseInt(args[1]);
            int price = Integer.parseInt(args[2]);

            purchases.add(new Purchase(name, price, count));

            line = reader.readLine();
        }

        fileReader.close();
        reader.close();

        return new Order(clientName, purchases);
    }

    public String getClientName() {
        return clientName;
    }

    public ArrayList<Purchase> getListOfPurchases() {
        return listOfPurchases;
    }

}
