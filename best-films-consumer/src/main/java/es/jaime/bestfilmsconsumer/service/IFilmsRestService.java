package es.jaime.bestfilmsconsumer.service;

import es.jaime.bestfilmsconsumer.model.Film;

public interface IFilmsRestService {

    Film findById(String filmId);
}
