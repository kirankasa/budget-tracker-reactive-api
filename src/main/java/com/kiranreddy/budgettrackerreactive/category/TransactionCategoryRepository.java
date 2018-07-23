package com.kiranreddy.budgettrackerreactive.category;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TransactionCategoryRepository extends ReactiveCrudRepository<TransactionCategory, String> {
}
