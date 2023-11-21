package com.cogenio.springbootproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JsonResponse {
    private String status;
    private String message;
    private int statusCode;

    public JsonResponse(HttpStatus httpStatus, String message) {
        this.status = httpStatus.is2xxSuccessful() ? "success" : "error";
        this.statusCode = httpStatus.value();
        this.message = message;
    }
}
