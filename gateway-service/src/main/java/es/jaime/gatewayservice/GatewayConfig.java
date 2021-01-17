package es.jaime.gatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableHystrix
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/users/**")
                        .filters(f -> f.hystrix(config -> config.setName("users-service")))
                        .uri("lb://users-service/")
                        .id("users-route"))
                .route(r -> r.path("/films/**")
                        .filters(f -> f.hystrix(config -> config.setName("films-service")))
                        .uri("lb://films-service/")
                        .id("films-route"))
                .route(r -> r.path("/ratefilm/**")
                        .filters(f -> f.hystrix(config -> config.setName("rate-films-rest-template")))
                        .uri("lb://rate-films/ratefilm")
                        .id("ratefilm-route-rest-template"))
                .route(r -> r.path("/ratefilmfeign/**")
                        .filters(f -> f.hystrix(config -> config.setName("rate-films-feign")))
                        .uri("lb://rate-films/ratefilmfeign")
                        .id("ratefilm-route-feign"))
                .build();
    }
}
