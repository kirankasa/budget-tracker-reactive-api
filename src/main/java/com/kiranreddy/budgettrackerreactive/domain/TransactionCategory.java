package com.kiranreddy.budgettrackerreactive.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class TransactionCategory {

	@Id
	private Long id;
	private String category;
	private Long userId;
}
