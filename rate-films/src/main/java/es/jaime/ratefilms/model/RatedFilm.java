package es.jaime.ratefilms.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RatedFilm {

    private String filmId;
    private String userId;
    private String username;
    private int score;
}
