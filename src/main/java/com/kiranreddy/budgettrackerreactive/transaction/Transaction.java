package com.kiranreddy.budgettrackerreactive.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.IOException;
import java.time.LocalDate;

@Document(collection = "transaction")
@Data
public class Transaction {

    @Id
    private String id;
    @JsonSerialize(using = TransactionTypeSerializer.class)
    private String type;
    private Double amount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String note;
    private String category;
}

class TransactionTypeSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String type,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        jsonGenerator.writeObject("D".equals(type)? "Debit" : "Credit");
    }
}