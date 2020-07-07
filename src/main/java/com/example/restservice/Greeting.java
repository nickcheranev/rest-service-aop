package com.example.restservice;

import org.springframework.core.style.ToStringCreator;

/**
 * @author Cheranev N.
 * created on 24.06.2020.
 */
public class Greeting {

    private final long id;
    private final String greeting;
    private final String message;

    public Greeting(long id, String content, String message) {
        this.id = id;
        this.greeting = content;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", id)
                .append("content", greeting)
                .append("message", message)
                .toString();
    }

}
