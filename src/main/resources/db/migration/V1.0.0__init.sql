CREATE TABLE heroes
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name VARCHAR(255) NOT NULL,
    CONSTRAINT heroes_pkey PRIMARY KEY (id)
);

CREATE INDEX name_idx
    ON heroes(name);

CREATE TABLE movies
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name VARCHAR(255),
    year smallint,
    CONSTRAINT movies_pkey PRIMARY KEY (id)
);

CREATE TABLE heroes_movies
(
    hero_id bigint NOT NULL,
    movie_id bigint NOT NULL,
    CONSTRAINT heroes_movies_pkey PRIMARY KEY (hero_id, movie_id),
    CONSTRAINT hero_id_fk FOREIGN KEY (hero_id)
        REFERENCES heroes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT movie_id_fk FOREIGN KEY (movie_id)
        REFERENCES movies (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);