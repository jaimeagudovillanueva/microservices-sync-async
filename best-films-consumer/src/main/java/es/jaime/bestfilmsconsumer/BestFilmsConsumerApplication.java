package es.jaime.bestfilmsconsumer;

import es.jaime.bestfilmsconsumer.model.Film;
import es.jaime.bestfilmsconsumer.model.GoodFilm;
import es.jaime.bestfilmsconsumer.service.IFilmsRestService;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Consumer;

@EnableEurekaClient
@SpringBootApplication
public class BestFilmsConsumerApplication {

	@Autowired
	IFilmsRestService filmsRestService;

	public static void main(String[] args) {
		SpringApplication.run(BestFilmsConsumerApplication.class, args);
	}

	@Bean
	public Consumer<GoodFilm> goodFilmsProcessor() {
		return goodFilm -> {
					Film film = filmsRestService.findById(goodFilm.getFilmId());
					System.out.println(goodFilm.getUsername() + " rated " +
							film.getTitle() + " with a " + goodFilm.getScore() +
							", the genre of the film is " + film.getGenre() +
							". Synopsis: "  + film.getDescription());
		};
	}
}
