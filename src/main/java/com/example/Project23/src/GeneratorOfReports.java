package com.example.Project23.src;

import java.util.HashMap;

public class GeneratorOfReports {
    private final TableOfPurchases tableOfPurchases;
    private final ReportOfPurchasesTable reportOfPurchasesTable;

    public GeneratorOfReports(TableOfPurchases tableOfPurchases) {
        this.tableOfPurchases = tableOfPurchases;
        reportOfPurchasesTable = new ReportOfPurchasesTable();
    }

    public ReportOfPurchasesTable getReportTable() {
        return reportOfPurchasesTable;
    }

    public void calculateReportOfPurchasesTable() {
        for (Order order : tableOfPurchases.getListOfOrders()) {
            for (Purchase purchase : order.getListOfPurchases()) {
                reportOfPurchasesTable.updatePrice(purchase.getName(), purchase.getPrice(), purchase.getCount());
            }
        }
    }

    public static class ReportOfPurchasesTable {
        private final HashMap<String, Integer> reportOfPurchases;

        public ReportOfPurchasesTable() {
            reportOfPurchases = new HashMap<>();
        }

        public void updatePrice(String name, int price, int count) {
            try {
                int totalPrice = reportOfPurchases.get(name);
                reportOfPurchases.put(name, totalPrice + (price * count));
            } catch (Exception e) {
                reportOfPurchases.put(name, (price * count));
            }
        }

        public HashMap<String, Integer> getReportOfPurchases() {
            return reportOfPurchases;
        }
    }
}
