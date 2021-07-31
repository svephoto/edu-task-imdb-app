package com.example.restfulwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicInteger counter = new AtomicInteger();
    private final GreetingRepository greetingRepository;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    public GreetingController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @GetMapping(path="/add")
    public Greeting addNewGreeting(@RequestParam String content) {
        Greeting currentGreeting = new Greeting();

        currentGreeting.setContent(content);

        return greetingRepository.save(currentGreeting);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Greeting> getAllUsers() {
        return greetingRepository.findAll();
    }
}
