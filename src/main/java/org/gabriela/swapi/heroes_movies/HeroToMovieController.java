package org.gabriela.swapi.heroes_movies;

import org.gabriela.swapi.heroes.Hero;
import org.gabriela.swapi.heroes.HeroRepository;
import org.gabriela.swapi.movies.Movie;
import org.gabriela.swapi.movies.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroToMovieController {

    private HeroRepository heroRepository;
    private MovieRepository movieRepository;

    public HeroToMovieController(HeroRepository repository, MovieRepository movieRepository) {
        this.heroRepository = repository;
        this.movieRepository = movieRepository;
    }

    @PostMapping("/heroes-to-movies")
    public ResponseEntity<HeroToMovie> createHeroMovieMapping(@RequestBody HeroToMovie heroToMovie) {
        Hero hero = heroRepository.getOne(heroToMovie.getHeroId());
        if (hero == null) {
            return ResponseEntity.notFound().build();
        }
        Movie movie = movieRepository.getOne(heroToMovie.getMovieId());

        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        hero.getMovies().add(movie);
        heroRepository.save(hero);
        return ResponseEntity.ok(heroToMovie);
    }
}
