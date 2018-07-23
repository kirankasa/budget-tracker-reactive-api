package com.kiranreddy.budgettrackerreactive.category;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionCategoryService {

	private TransactionCategoryRepository transactionCategoryRepository;

	public TransactionCategoryService(TransactionCategoryRepository transactionCategoryRepository) {
		this.transactionCategoryRepository = transactionCategoryRepository;
	}

	public Flux<TransactionCategory> retrieveTransactionCategories() {
		return transactionCategoryRepository.findAll();
	}

	public Mono<TransactionCategory> saveTransactionCategory(TransactionCategory transactionCategory) {
		return transactionCategoryRepository.save(transactionCategory);
	}

}
