package org.gabriela.swapi.movies;

import org.gabriela.swapi.heroes.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MoviesController {

    private MovieRepository repository;

    @Autowired
    public MoviesController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping ("/movies/{id}")
    public Movie movies(@PathVariable("id") long id) {
        Movie movie = repository.getOne(id);
        return movie;
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie newMovie = repository.save(movie);
        return ResponseEntity.ok(newMovie);
    }
}
