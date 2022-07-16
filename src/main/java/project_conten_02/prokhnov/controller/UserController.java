package project_conten_02.prokhnov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project_conten_02.prokhnov.model.User;
import project_conten_02.prokhnov.service.UserService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    @RolesAllowed("ROLE_ADMIN")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping(value = "/users")
    public User createNewUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @PutMapping(value = "/users")
    public User updateUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @GetMapping(value = "/users/{userId}")
    public User getUserById(@PathVariable long userId){
        return userService.getById(userId);
    }

    @DeleteMapping(value = "/users/{userId}")
    public String deleteUserById(@PathVariable long userId){
        return userService.deleteById(userId);
    }
}
