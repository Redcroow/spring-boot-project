package com.cogenio.springbootproject.controller;

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
        String message = helloWorldService.getHelloWorld();
        return new JsonResponse("success", message);
    }
}
