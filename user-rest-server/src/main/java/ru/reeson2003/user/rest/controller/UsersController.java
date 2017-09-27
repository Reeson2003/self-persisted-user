package ru.reeson2003.user.rest.controller;

import org.springframework.web.bind.annotation.*;
import ru.reeson2003.user.api.User;
import ru.reeson2003.user.api.Users;
import ru.reeson2003.user.exception.CreateUserException;
import ru.reeson2003.user.exception.SearchUserException;
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

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public boolean newUser(@RequestParam("login") String login, @RequestParam("password") String password) {
        try {
            users.newUser(login, password).build();
            return true;
        } catch (CreateUserException e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public User getByLogin(@RequestParam("login") String login) {
        try {
            return users.findOne(login);
        } catch (SearchUserException e) {
            return null;
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    @ResponseBody
    public boolean updateUser(@RequestBody() User user) {
        return update(user);
    }

    private boolean update(User user) {
        try {
            User persisted = users.findOne(user.getLogin());
            persisted.setEmail(user.getEmail());
            persisted.setBirthDate(user.getBirthDate());
            persisted.setFirstName(user.getFirstName());
            persisted.setLastName(user.getLastName());
            persisted.setLoggedIn(user.isLoggedIn());
            persisted.setMiddleName(user.getMiddleName());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteUser(@RequestBody() User user) {
        return delete(user);
    }

    private boolean delete(User user) {
        try {
            User persisted = users.findOne(user.getLogin());
            persisted.delete();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
