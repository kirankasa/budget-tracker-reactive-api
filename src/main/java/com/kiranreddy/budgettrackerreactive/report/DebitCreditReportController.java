package com.kiranreddy.budgettrackerreactive.report;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("transactions/type/report")
public class DebitCreditReportController {

    private DebitCreditReportService debitCreditReportService;

    public DebitCreditReportController(DebitCreditReportService debitCreditReportService) {
        this.debitCreditReportService = debitCreditReportService;
    }

    @GetMapping
    public Flux<String> getDebitCreditReport(){
        return debitCreditReportService.getDebitCreditData();
    }
}
