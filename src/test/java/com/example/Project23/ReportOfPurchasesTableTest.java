package com.example.Project23;

import com.example.Project23.src.GeneratorOfReports;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReportOfPurchasesTableTest {
    private GeneratorOfReports.ReportOfPurchasesTable reportOfPurchasesTable;

    @BeforeEach
    public void setUp() {
        reportOfPurchasesTable = new GeneratorOfReports.ReportOfPurchasesTable();
    }

    @Test
    public void updatePriceTest() {
        reportOfPurchasesTable.updatePrice("Purchase1", 12, 1);
        reportOfPurchasesTable.updatePrice("Purchase2", 22, 2);
        reportOfPurchasesTable.updatePrice("Purchase3", 452, 1);
        reportOfPurchasesTable.updatePrice("Purchase1", 33, 3);
        reportOfPurchasesTable.updatePrice("Purchase5", 100, 2);
        reportOfPurchasesTable.updatePrice("Purchase1", 44, 1);

        Assertions.assertEquals(155, reportOfPurchasesTable.getReportOfPurchases().get("Purchase1"));
        Assertions.assertEquals(44, reportOfPurchasesTable.getReportOfPurchases().get("Purchase2"));
        Assertions.assertEquals(452, reportOfPurchasesTable.getReportOfPurchases().get("Purchase3"));
        Assertions.assertEquals(200, reportOfPurchasesTable.getReportOfPurchases().get("Purchase5"));
    }
}
