package es.jaime.films.controller;

import es.jaime.films.model.entity.Film;
import es.jaime.films.model.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private IFilmService filmService;

    @GetMapping("/films")
    public List<Film> getFilms() {
        return filmService.findAll();
    }

    @GetMapping("/films/${filmId]")
    public Film getFilm(@PathVariable Long filmId) {
        return filmService.findById(filmId);
    }
}
