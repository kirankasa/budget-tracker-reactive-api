package com.kiranreddy.budgettrackerreactive.transaction;


import com.kiranreddy.budgettrackerreactive.category.TransactionCategory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TransactionRepository extends ReactiveCrudRepository<Transaction, String> {
}
