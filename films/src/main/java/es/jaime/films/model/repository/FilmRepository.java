package es.jaime.films.model.repository;

import es.jaime.films.model.entity.Film;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmRepository extends MongoRepository<Film, Long> {
}
