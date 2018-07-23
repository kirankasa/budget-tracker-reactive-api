package com.kiranreddy.budgettrackerreactive.category;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaction_category")
@Data
public class TransactionCategory {

	@Id
	private String id;
	private String category;
}
