package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Cheranev N.
 * created on 24.06.2020.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    @Loggable
    public Greeting greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name
            , @RequestParam(value = "message") String message) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name), message);
    }
}
