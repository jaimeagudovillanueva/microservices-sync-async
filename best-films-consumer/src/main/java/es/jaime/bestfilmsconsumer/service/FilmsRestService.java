package es.jaime.bestfilmsconsumer.service;

import es.jaime.bestfilmsconsumer.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class FilmsRestService implements IFilmsRestService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public Film findById(String filmId) {
        return webClientBuilder.build().get().uri("http://gateway-service/films/{filmId}", filmId).retrieve().bodyToMono(Film.class).block();
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }
}
