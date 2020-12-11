package com.example.Project23;

import com.example.Project23.src.GeneratorOfReports;
import com.example.Project23.src.Order;
import com.example.Project23.src.Purchase;
import com.example.Project23.src.TableOfPurchases;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.ArrayList;

public class GeneratorOfReportsTests {
    private GeneratorOfReports generatorOfReports;
    private ArrayList<String> filenames;

    @BeforeEach
    public void setUp() {
        filenames = new ArrayList<>();
        filenames.add("./src/main/resources/Order1.txt");
        filenames.add("./src/main/resources/Order2.txt");
        filenames.add("./src/main/resources/Order3.txt");

        String client1Name = "Bob";
        String client2Name = "Leo";
        String client3Name = "John";

        Purchase purchase1 = new Purchase("Purchase1", 123, 1);
        Purchase purchase2 = new Purchase("Purchase2", 55, 2);
        Purchase purchase3 = new Purchase("Purchase3", 89, 1);
        Purchase purchase4 = new Purchase("Purchase4", 22, 4);
        Purchase purchase5 = new Purchase("Purchase5", 57, 3);

        ArrayList<Purchase> listOfPurchasesFirstClient = new ArrayList<>();
        ArrayList<Purchase> listOfPurchasesSecondClient = new ArrayList<>();
        ArrayList<Purchase> listOfPurchasesThirdClient = new ArrayList<>();

        listOfPurchasesFirstClient.add(purchase1);
        listOfPurchasesFirstClient.add(purchase2);

        listOfPurchasesSecondClient.add(purchase3);
        listOfPurchasesSecondClient.add(purchase5);

        listOfPurchasesThirdClient.add(purchase1);
        listOfPurchasesThirdClient.add(purchase4);
        listOfPurchasesThirdClient.add(purchase5);

        Order order1 = new Order(client1Name, listOfPurchasesFirstClient);
        Order order2 = new Order(client2Name, listOfPurchasesSecondClient);
        Order order3 = new Order(client3Name, listOfPurchasesThirdClient);

        ArrayList<Order> orders = new ArrayList<>();

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        TableOfPurchases tableOfPurchases = new TableOfPurchases(orders);
        generatorOfReports = new GeneratorOfReports(tableOfPurchases);
    }

    @Test
    public void calculateReportOfPurchasesTableTest() {
        generatorOfReports.calculateReportOfPurchasesTable();
        Assertions.assertFalse(generatorOfReports.getReportTable().getReportOfPurchases().isEmpty());

        Assertions.assertEquals(246, generatorOfReports.getReportTable().getReportOfPurchases().get("Purchase1"));
        Assertions.assertEquals(110, generatorOfReports.getReportTable().getReportOfPurchases().get("Purchase2"));
        Assertions.assertEquals(89, generatorOfReports.getReportTable().getReportOfPurchases().get("Purchase3"));
        Assertions.assertEquals(88, generatorOfReports.getReportTable().getReportOfPurchases().get("Purchase4"));
        Assertions.assertEquals(342, generatorOfReports.getReportTable().getReportOfPurchases().get("Purchase5"));
    }

    @Test
    public void testReadFile() throws IOException {
        TableOfPurchases tableOfPurchases = TableOfPurchases.readTableOfPurchases(filenames);

        GeneratorOfReports generatorOfReportsFromFile = new GeneratorOfReports(tableOfPurchases);

        generatorOfReportsFromFile.calculateReportOfPurchasesTable();
        Assertions.assertFalse(generatorOfReportsFromFile.getReportTable().getReportOfPurchases().isEmpty());

        Assertions.assertEquals(369, generatorOfReportsFromFile.getReportTable().getReportOfPurchases().get("Purchase1"));
        Assertions.assertEquals(110, generatorOfReportsFromFile.getReportTable().getReportOfPurchases().get("Purchase2"));
        Assertions.assertEquals(89, generatorOfReportsFromFile.getReportTable().getReportOfPurchases().get("Purchase3"));
        Assertions.assertEquals(88, generatorOfReportsFromFile.getReportTable().getReportOfPurchases().get("Purchase4"));
        Assertions.assertEquals(342, generatorOfReportsFromFile.getReportTable().getReportOfPurchases().get("Purchase5"));
    }
}
