package org.gabriela.swapi.heroes;

import org.gabriela.swapi.heroes_movies.HeroToMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HeroesController {

    private HeroRepository repository;

    @Autowired
    public HeroesController (HeroRepository repository){
        this.repository = repository;
    }

    @GetMapping("/heroes/{id}")
    public ResponseEntity<Hero> getHeroByID(@PathVariable("id")long id) {
        Hero hero = repository.getOne(id);
        return ResponseEntity.ok(hero);
    }

    @GetMapping("/heroes")
    public ResponseEntity<Hero> getHeroByName(@RequestParam("name") String name) {
        Hero hero = repository.findHeroByName(name);
        return ResponseEntity.ok(hero);
    }

    @PostMapping("/heroes")
    public ResponseEntity<Hero> createHero(@RequestBody Hero hero) {
        Hero newHero = repository.save(hero);
        return ResponseEntity.ok(newHero);
    }
}
