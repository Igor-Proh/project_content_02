package project_conten_02.prokhnov.service;

import project_conten_02.prokhnov.model.Component;
import project_conten_02.prokhnov.model.User;

import java.util.List;

public interface UserService {

    User findUserByUserEmail(String userEmail);

    void saveUser(User user);

    List<User> findAll();

    User getById(long id);

    String deleteById(long id);
}
