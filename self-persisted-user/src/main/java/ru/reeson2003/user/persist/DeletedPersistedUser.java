package ru.reeson2003.user.persist;

import ru.reeson2003.user.exception.DeletedUserException;

import java.util.Date;

/**
 * Date: 03.09.2017.
 * Time: 16:09.
 *
 * @author Pavel Gavrilov.
 */
public class DeletedPersistedUser extends PersistedUser {
    @Override
    public long getId() {
        throw new DeletedUserException();
    }

    @Override
    public void setId(long id) {
        throw new DeletedUserException();
    }

    @Override
    public String getFirstName() {
        throw new DeletedUserException();
    }

    @Override
    public void setFirstName(String firstName) {
        throw new DeletedUserException();
    }

    @Override
    public String getMiddleName() {
        throw new DeletedUserException();
    }

    @Override
    public void setMiddleName(String middleName) {
        throw new DeletedUserException();
    }

    @Override
    public String getLastName() {
        throw new DeletedUserException();
    }

    @Override
    public void setLastName(String lastName) {
        throw new DeletedUserException();
    }

    @Override
    public Date getBirthDate() {
        throw new DeletedUserException();
    }

    @Override
    public void setBirthDate(Date birthDate) {
        throw new DeletedUserException();
    }

    @Override
    public String getEmail() {
        throw new DeletedUserException();
    }

    @Override
    public void setEmail(String email) {
        throw new DeletedUserException();
    }

    @Override
    public String getLogin() {
        throw new DeletedUserException();
    }

    @Override
    public void setLogin(String login) {
        throw new DeletedUserException();
    }

    @Override
    public String getPassword() {
        throw new DeletedUserException();
    }

    @Override
    public void setPassword(String password) {
        throw new DeletedUserException();
    }

    @Override
    public Date getRegisterDate() {
        throw new DeletedUserException();
    }

    @Override
    public void setRegisterDate(Date registerDate) {
        throw new DeletedUserException();
    }

    @Override
    public Date getUpdateDate() {
        throw new DeletedUserException();
    }

    @Override
    public void setUpdateDate(Date updateDate) {
        throw new DeletedUserException();
    }

    @Override
    public boolean isLoggedIn() {
        throw new DeletedUserException();
    }

    @Override
    public void setLoggedIn(boolean loggedIn) {
        throw new DeletedUserException();
    }
}
