package org.gabriela.swapi.heroes;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.gabriela.swapi.movies.Movie;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "heroes", schema = "starwars_api", indexes = {@Index(columnList = "name", name = "name_idx")})
@JsonIgnoreProperties( { "hibernateLazyInitializer" } )
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "heroes_movies",
            schema = "starwars_api",
            joinColumns = { @JoinColumn(name = "hero_id") },
            inverseJoinColumns = { @JoinColumn(name = "movie_id") })
    private Set<Movie> movies = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }
}
