package com.cogenio.springbootproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogenio.springbootproject.model.JsonResponse;
import com.cogenio.springbootproject.service.HelloWorldService;

@RestController
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("/hello")
    public JsonResponse getHelloWorld() {
        try {
            String message = helloWorldService.getHelloWorld();
            return new JsonResponse(HttpStatus.OK, message);
        } catch (Exception e) {
            return new JsonResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
