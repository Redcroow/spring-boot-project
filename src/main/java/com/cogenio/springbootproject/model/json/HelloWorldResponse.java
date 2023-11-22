package com.cogenio.springbootproject.model.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HelloWorldResponse {
    private String status;
    private String message;
    private int statusCode;

    public HelloWorldResponse(HttpStatus httpStatus, String message) {
        this.status = httpStatus.is2xxSuccessful() ? "success" : "error";
        this.statusCode = httpStatus.value();
        this.message = message;
    }
}
