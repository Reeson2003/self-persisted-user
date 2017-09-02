package ru.reeson2003.user.api;

import java.util.List;

/**
 * Date: 31.08.2017.
 * Time: 22:11.
 *
 * @author Pavel Gavrilov.
 */
public interface Users {
    UserBuilder newUser(String login, String password);

    List<User> getUsers();

    void deleteUser(User user);
}
