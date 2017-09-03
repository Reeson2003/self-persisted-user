package ru.reeson2003.user.api;

import java.util.Date;

/**
 * Date: 31.08.2017.
 * Time: 22:07.
 *
 * @author Pavel Gavrilov.
 */
public interface User {
    String getFirstName();

    void setFirstName(String firstName);

    String getMiddleName();

    void setMiddleName(String middleName);

    String getLastName();

    void setLastName(String lastName);

    Date getBirthDate();

    void setBirthDate(Date birthDate);

    String getEmail();

    void setEmail(String email);

    String getLogin();

    String getPassword();

    boolean isLoggedIn();

    void setLoggedIn(boolean loggedIn);

    Date getRegisterDate();

    Date getUpdateDate();

    void delete();
}
