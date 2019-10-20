package org.gabriela.swapi.heroes_movies;

public class HeroToMovie {

    private long heroId;
    private long movieId;

    public HeroToMovie(long heroId, long movieId) {
        this.heroId = heroId;
        this.movieId = movieId;
    }

    public long getHeroId() {
        return heroId;
    }

    public long getMovieId() {
        return movieId;
    }
}
