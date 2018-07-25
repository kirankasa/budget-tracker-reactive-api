package com.kiranreddy.budgettrackerreactive.transaction;

import com.kiranreddy.budgettrackerreactive.category.TransactionCategory;
import com.kiranreddy.budgettrackerreactive.category.TransactionCategoryService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/transactions")
@CrossOrigin
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public Flux<Transaction> retrieveTransactions() {
        return transactionService.retrieveTransactions();
    }

    @GetMapping("/{id}")
    public Mono<Transaction> findTransactionById(@PathVariable("id") String id) {
        return transactionService.findTransactionById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteTransactionById(@PathVariable("id") String id) {
        return transactionService.deleteTransaction(id);
    }

    @PostMapping
    public Mono<Transaction> saveTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

}
