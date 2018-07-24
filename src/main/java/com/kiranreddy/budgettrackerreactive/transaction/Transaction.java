package com.kiranreddy.budgettrackerreactive.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "transaction")
@Data
public class Transaction {

	@Id
	private String id;
	private String type;
	private Double amount;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private String note;
	private String category;
}
