package es.jaime.users.model.service;

import es.jaime.users.model.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    User findById(String userId);
    User save(User user);
    User update(User user, String userId);
    void delete(String userId);
}
