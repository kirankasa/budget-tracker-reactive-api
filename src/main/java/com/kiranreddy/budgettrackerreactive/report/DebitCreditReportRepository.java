package com.kiranreddy.budgettrackerreactive.report;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

@Repository
public class DebitCreditReportRepository {

    private ReactiveMongoTemplate reactiveMongoTemplate;

    public DebitCreditReportRepository(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    public Flux<String> getDebitCreditData() {
        ProjectionOperation projectMonthAndYear = project("date")
                .andExpression("date")
                .dateAsFormattedString("%m-%Y")
                .as("formateddate")
                .and("amount")
                .as("amount")
                .and("type")
                .as("type");

        GroupOperation groupByTypeAndSumAmount = group("type")
                .sum("amount").as("amount");
        Aggregation aggregation = newAggregation(projectMonthAndYear, groupByTypeAndSumAmount);
        Flux<String> result = reactiveMongoTemplate.aggregate(
                aggregation, "transaction", String.class);
        return result;
    }
}
