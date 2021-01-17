package es.jaime.ratefilms.controller;

import es.jaime.ratefilms.model.RatedFilm;
import es.jaime.ratefilms.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RateFilmRestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping("/ratefilm")
    public void rateFilm(@RequestBody RatedFilm ratedFilm) {

        final User user = restTemplate.getForObject("http://gateway-service/users/" + ratedFilm.getUserId(), User.class);
        ratedFilm.setUsername(user.getUsername());

        streamBridge.send("output", ratedFilm);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
