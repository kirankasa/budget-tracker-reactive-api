package com.kiranreddy.budgettrackerreactive.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonProperty.*;

@Document(collection = "user")
@Data
public class User {

    @Id
    private String id;
    @Indexed(unique = true)
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

}
