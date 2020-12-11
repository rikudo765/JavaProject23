package com.example.Project23.api;

import com.example.Project23.src.GeneratorOfReports;
import com.example.Project23.src.TableOfPurchases;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    // private static Logger logger = LoggerFactory.getLogger(Controller.class);

    @RequestMapping(method = RequestMethod.GET, value = "/report/purchases")
    public ResponseEntity<GeneratorOfReports.ReportOfPurchasesTable> getReportOfPurchases(@RequestBody TableOfPurchases table) {
        GeneratorOfReports generator = new GeneratorOfReports(table);
        generator.calculateReportOfPurchasesTable();

        return new ResponseEntity<>(generator.getReportTable(), HttpStatus.OK);
    }
}
