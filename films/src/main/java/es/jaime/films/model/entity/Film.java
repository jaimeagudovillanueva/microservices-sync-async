package es.jaime.films.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
@Document("films")
public class Film {

    @Id
    private String id;

    private String title;
    private String description;
    private String genre;
}
