package com.kiranreddy.budgettrackerreactive.report;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class DebitCreditReportService {

    private DebitCreditReportRepository reportRepository;

    public DebitCreditReportService(DebitCreditReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Flux<String> getDebitCreditData() {
        return reportRepository.getDebitCreditData();
    }
}
