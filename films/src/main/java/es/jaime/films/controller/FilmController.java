package es.jaime.films.controller;

import es.jaime.films.model.entity.Film;
import es.jaime.films.model.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private IFilmService filmService;

    @GetMapping("/films")
    public List<Film> getFilms() {
        return filmService.findAll();
    }

    @GetMapping("/films/{filmId}")
    public Film getFilm(@PathVariable String filmId) {
        return filmService.findById(filmId);
    }

    @PostMapping("/films")
    @ResponseStatus(HttpStatus.CREATED)
    public Film saveFilm(@RequestBody Film film) {
        return filmService.save(film);
    }

    @PutMapping("/films/{filmId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Film updateFilm(@RequestBody Film film, @PathVariable String filmId) {
        return filmService.update(film, filmId);
    }

    @DeleteMapping("/films/{filmId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFilm(@PathVariable String filmId) {
        filmService.delete(filmId);
    }
}
