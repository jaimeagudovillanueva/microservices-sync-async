package es.jaime.ratefilms.client;

import es.jaime.ratefilms.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("gateway-service")
public interface IUserFeignClient {

    @GetMapping("/users/{userId}")
    User getUser(@PathVariable String userId);
}
