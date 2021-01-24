package es.jaime.bestfilmsconsumer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Film {

    private String id;
    private String title;
    private String description;
    private String genre;
}
