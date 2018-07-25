package com.kiranreddy.budgettrackerreactive.transaction;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {

	private TransactionRepository transactionRepository;

	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public Flux<Transaction> retrieveTransactions() {
		return transactionRepository.findAll();
	}

	public Mono<Transaction> saveTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public Mono<Void> deleteTransaction(String id) {
		return transactionRepository.deleteById(id);
	}

	public Mono<Transaction> findTransactionById(String id) {
		return transactionRepository.findById(id).switchIfEmpty(Mono.error(new RuntimeException("No transaction found")));
	}
}
