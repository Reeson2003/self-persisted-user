package ru.reeson2003.user.api;

import ru.reeson2003.user.exception.CreateUserException;
import ru.reeson2003.user.exception.SearchUserException;

import java.util.List;

/**
 * Date: 31.08.2017.
 * Time: 22:11.
 *
 * @author Pavel Gavrilov.
 */
public interface Users {
    UserBuilder newUser(String login, String password) throws CreateUserException;

    List<User> getUsers();

    User findOne(String login) throws SearchUserException;
}
