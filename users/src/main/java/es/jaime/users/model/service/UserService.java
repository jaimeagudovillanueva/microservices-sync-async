package es.jaime.users.model.service;

import es.jaime.users.model.entity.User;
import es.jaime.users.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(User user, String userId) {
        User userToUpdate = findById(userId);
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setUsername(user.getUsername());
        return userRepository.save(userToUpdate);
    }

    @Override
    @Transactional
    public void delete(String userId) {
        userRepository.deleteById(userId);
    }
}
