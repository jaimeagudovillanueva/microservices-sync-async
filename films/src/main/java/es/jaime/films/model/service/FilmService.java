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
    public Film findById(final Long id) {
        return filmRepository.findById(id).orElse(null);
    }
}
