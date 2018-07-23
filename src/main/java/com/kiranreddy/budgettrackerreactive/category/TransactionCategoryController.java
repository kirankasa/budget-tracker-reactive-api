package com.kiranreddy.budgettrackerreactive.category;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/transactions/categories")
public class TransactionCategoryController {

    private TransactionCategoryService transactionCategoryService;

    public TransactionCategoryController(TransactionCategoryService transactionCategoryService) {
        this.transactionCategoryService = transactionCategoryService;
    }

    @GetMapping
    public Flux<TransactionCategory> retrieveCategories() {
        return transactionCategoryService.retrieveTransactionCategories();
    }

    @PostMapping
    public Mono<TransactionCategory> saveTransactionCategory(@RequestBody TransactionCategory transactionCategory) {
        return transactionCategoryService.saveTransactionCategory(transactionCategory);
    }
}
