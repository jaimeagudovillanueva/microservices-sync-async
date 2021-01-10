package es.jaime.films.model.service;

import es.jaime.films.model.entity.Film;

import java.util.List;

public interface IFilmService {

    List<Film> findAll();

    Film findById(Long id);
}
