package com.kiranreddy.budgettrackerreactive.category;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/transactions/categories")
@CrossOrigin
public class TransactionCategoryController {

    private TransactionCategoryService transactionCategoryService;

    public TransactionCategoryController(TransactionCategoryService transactionCategoryService) {
        this.transactionCategoryService = transactionCategoryService;
    }

    @GetMapping
    public Flux<TransactionCategory> retrieveCategories() {
        return transactionCategoryService.retrieveTransactionCategories();
    }

    @GetMapping("/{id}")
    public Mono<TransactionCategory> findCategoryById(@PathVariable("id") String id) {
        return transactionCategoryService.findCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCategory(@PathVariable("id") String id) {
        return transactionCategoryService.deleteCategory(id);
    }

    @PostMapping
    public Mono<TransactionCategory> saveTransactionCategory(@RequestBody TransactionCategory transactionCategory) {
        return transactionCategoryService.saveTransactionCategory(transactionCategory);
    }
}
