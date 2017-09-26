package ru.reeson2003.user.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.reeson2003.user.api.User;
import ru.reeson2003.user.api.Users;
import ru.reeson2003.user.exception.CreateUserException;
import ru.reeson2003.user.util.UsersProvider;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Pavel Gavrilov on 26.09.2017.
 */
@RestController
public class UsersController {
    private Users users;

    @PostConstruct
    private void init() {
        users = UsersProvider.getUsers();
        users = UsersProvider.getCachingUsers(users);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAll() {
        return users.getUsers();
    }

    @RequestMapping(value = "/users")
    public boolean newUser(@RequestParam("login") String login, @RequestParam("password") String password) {
        try {
            users.newUser(login, password).build();
            return true;
        } catch (CreateUserException e) {
            e.printStackTrace();
            return false;
        }
    }
}
