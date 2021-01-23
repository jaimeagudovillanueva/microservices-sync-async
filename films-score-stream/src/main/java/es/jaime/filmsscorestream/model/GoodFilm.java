package es.jaime.filmsscorestream.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoodFilm {

    private String filmId;
    private String username;
    private int score;
}
