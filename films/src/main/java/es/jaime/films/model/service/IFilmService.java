package es.jaime.films.model.service;

import es.jaime.films.model.entity.Film;

import java.util.List;

public interface IFilmService {

    List<Film> findAll();
    Film findById(String id);
    Film save(Film film);
    Film update(Film film, String filmId);
    void delete(String filmId);
}
