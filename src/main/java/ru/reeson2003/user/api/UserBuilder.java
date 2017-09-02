package ru.reeson2003.user.api;

import java.util.Date;

/**
 * Date: 31.08.2017.
 * Time: 22:16.
 *
 * @author Pavel Gavrilov.
 */
public interface UserBuilder {
    UserBuilder firstName(String firstName);
    UserBuilder middleName(String middleName);
    UserBuilder lastName(String lastName);
    UserBuilder birthDate(Date birthDate);
    UserBuilder email(String email);
    UserBuilder loggedIn(boolean loggedIn);
    User build();
}
