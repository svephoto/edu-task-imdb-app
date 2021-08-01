package com.example.restfulwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicInteger counter = new AtomicInteger();
    private final GreetingRepository greetingRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    public GreetingController(GreetingRepository greetingRepository, UserRepository userRepository,
                              MovieRepository movieRepository) {
        this.greetingRepository = greetingRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping(path = "/addGreeting")
    public Greeting addNewGreeting(@RequestParam String content) {
        Greeting currentGreeting = new Greeting();

        currentGreeting.setContent(content);

        return greetingRepository.save(currentGreeting);
    }

    @GetMapping(path = "/allGreetings")
    public @ResponseBody Iterable<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @GetMapping(path = "/addMovie")
    public Movie addNewMovie(@RequestParam Long id) {
        Movie currentMovie = new Movie();

        currentMovie.setId(id);

        return movieRepository.save(currentMovie);
    }

    @GetMapping(path = "/allMovies")
    public @ResponseBody Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping(path = "/addUsers")
    public User addNewUser(@RequestParam Long id) {
        User currentUser = new User();

        currentUser.setId(id);

        return userRepository.save(currentUser);
    }

    @GetMapping(path = "/allUsers")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
