package ru.reeson2003.user.impl;

import org.junit.Test;
import ru.reeson2003.user.api.User;
import ru.reeson2003.user.exception.CreateUserException;
import ru.reeson2003.user.exception.SearchUserException;
import ru.reeson2003.user.persist.PersistedUser;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Date: 03.09.2017.
 * Time: 16:39.
 *
 * @author Pavel Gavrilov.
 */
public class UsersTest extends AbstractTest {

    @Test
    @Transactional
    public void newUserTest() throws CreateUserException {
        final String login = "Tommy";
        final String password = "11223344";
        User user = users.newUser(login, password).build();
        assertNotNull("User is null", user);
    }

    @Test(expected = CreateUserException.class)
    @Transactional
    public void uniqueLoginTest() throws CreateUserException {
        final String login = "Tommy";
        final String password = "11223344";
        User user = users.newUser(login, password).build();
        assertNotNull("User is null", user);
        User another = users.newUser(login, password).build();
    }

    @Test
    @Transactional
    public void findByLoginTest() throws CreateUserException, SearchUserException {
        final String login = "Tommy";
        final String password = "11223344";
        User user = users.newUser(login, password).build();
        assertNotNull("User is null", user);
        User clone = users.findOne(login);
        assertNotNull("User not found by login", clone);
    }

    @Test
    @Transactional
    public void listOfUserTest() throws CreateUserException {
        final String login1 = "Tommy";
        final String password1 = "11223344";
        final String login2 = "Franky";
        final String password2 = "000000";
        User tommy = users.newUser(login1, password1).build();
        User franky = users.newUser(login2, password2).build();
        List<User> userList = users.getUsers();
        assertNotNull("List of users is null", userList);
        assertEquals(2, userList.size());
        User one = userList.get(0);
        User two = userList.get(1);
        if (one.getLogin().equals(tommy.getLogin()))
            assertEquals(two.getLogin(), franky.getLogin());
        else {
            assertEquals(one.getLogin(), franky.getLogin());
            assertEquals(two.getLogin(), tommy.getLogin());
        }
    }

    @Test
    @Transactional
    public void parallelUserModificationTest() throws CreateUserException, SearchUserException {
        final String login = "Tommy";
        final String password = "11223344";
        final String email = "tommy@mail.ru";
        User user = users.newUser(login, password).build();
        assertNotNull("User is null", user);
        User clone = users.findOne(login);
        assertNotNull("User is null", clone);
        user.setEmail(email);
        String userEmail = user.getEmail();
        assertNotNull("Email is null", userEmail);
        assertEquals(email, userEmail);
        String cloneEmail = clone.getEmail();
        assertNotNull("Email is null", cloneEmail);
        assertEquals(userEmail, cloneEmail);
    }
}
