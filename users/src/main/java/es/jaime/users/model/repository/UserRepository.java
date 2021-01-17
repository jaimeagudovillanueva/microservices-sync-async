package es.jaime.users.model.repository;

import es.jaime.users.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
