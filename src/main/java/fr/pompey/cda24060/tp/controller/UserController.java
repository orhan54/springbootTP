package fr.pompey.cda24060.tp.controller;

import fr.pompey.cda24060.tp.model.User;
import fr.pompey.cda24060.tp.repository.UserRepository;
import fr.pompey.cda24060.tp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{idUser}")
    public User getUserById(@PathVariable int idUser) {
        Optional<User> user = userService.getIdUser(idUser);
        return user.orElse(null);
    }

    @PutMapping("/user/{idUser}")
    public User updateUser(@PathVariable int idUser, @RequestBody User user) {
        Optional<User> userOptional = userService.getIdUser(idUser);

        if (userOptional.isPresent()) {
            User updatedUser = userOptional.get();

            String userFirstName = user.getUserFisrtName();
            if(userFirstName != null) {
                updatedUser.setUserFisrtName(userFirstName);
            }

            String userLastName = user.getUserLastName();
            if(userLastName != null) {
                updatedUser.setUserLastName(userLastName);
            }

            userService.saveUser(updatedUser);
            return updatedUser;

        }else {
            return null;
        }
    }

    @DeleteMapping("/user/{idUser}")
    public void deleteUser(@PathVariable int idUser) {
        userService.deleteUsers(idUser);
    }

}
