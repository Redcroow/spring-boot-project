package com.cogenio.springbootproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JsonResponse {
    private String status;
    private String message;
}
