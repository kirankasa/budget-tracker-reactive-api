package com.kiranreddy.budgettrackerreactive.report;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class DebitCreditData {
    @Id
    private String type;
    private Double amount;
}
