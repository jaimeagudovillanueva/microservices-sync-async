package es.jaime.filmsscorestream;

import es.jaime.filmsscorestream.model.GoodFilm;
import es.jaime.filmsscorestream.model.RatedFilm;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class FilmsScoreStreamApplication {

	private static final Long GOOD_SCORE = 8L;

	public static void main(String[] args) {
		SpringApplication.run(FilmsScoreStreamApplication.class, args);
	}

	@Bean
	public Function<KStream<String, RatedFilm>, KStream<String, GoodFilm>> filmScoresProcessor(){
		return kStream ->  kStream.peek((key, value) -> System.out.println("Processing score with film id: " + value.getFilmId()))
				.filter((key, ratedFilm) -> ratedFilm.getScore() >= GOOD_SCORE)
				.map((key, ratedFilm) -> new KeyValue<>(key, new GoodFilm(ratedFilm.getFilmId(),
						ratedFilm.getUsername(), ratedFilm.getScore())));
	};
}
