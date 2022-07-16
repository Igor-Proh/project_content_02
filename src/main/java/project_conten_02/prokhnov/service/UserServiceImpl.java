package project_conten_02.prokhnov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_conten_02.prokhnov.ProjectNotFoundException;
import project_conten_02.prokhnov.UserNotFoundException;
import project_conten_02.prokhnov.model.Project;
import project_conten_02.prokhnov.model.User;
import project_conten_02.prokhnov.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByUserEmail(String userEmail) {
        if (userRepository.findByUserEmail(userEmail).isPresent()) {
            return userRepository.findByUserEmail(userEmail).get();
        } else {
            throw new UserNotFoundException("User with this E-mail not found");
        }
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public String deleteById(long id) {
        userRepository.deleteById(id);
        return "Deleted user with id - " + id;

    }
}
