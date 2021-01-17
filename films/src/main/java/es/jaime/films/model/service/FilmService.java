package es.jaime.films.model.service;

import es.jaime.films.model.entity.Film;
import es.jaime.films.model.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmService implements IFilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Film> findAll() {
        return (List<Film>) filmRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Film findById(final String id) {
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Film save(Film film) {
        return filmRepository.save(film);
    }

    @Override
    @Transactional
    public Film update(Film film, String filmId) {
        Film filmToUpdate = findById(filmId);
        filmToUpdate.setDescription(film.getDescription());
        filmToUpdate.setGenre(film.getGenre());
        filmToUpdate.setTitle(film.getTitle());
        return save(filmToUpdate);
    }

    @Override
    @Transactional
    public void delete(String filmId) {
        filmRepository.deleteById(filmId);
    }
}
