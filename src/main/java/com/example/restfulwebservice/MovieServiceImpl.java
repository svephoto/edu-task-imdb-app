package com.example.restfulwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void createAndSaveMovie(String name) {
        Movie movie = new Movie();
        movie.setName(name);

        movieRepository.save(movie);
    }
}
