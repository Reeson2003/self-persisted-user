package ru.reeson2003.user.impl;

import ru.reeson2003.user.api.User;
import ru.reeson2003.user.persist.DeletedPersistedUser;
import ru.reeson2003.user.persist.PersistedUser;
import ru.reeson2003.user.persist.UserJpaRepository;

import java.util.Date;

/**
 * Date: 31.08.2017.
 * Time: 22:45.
 *
 * @author Pavel Gavrilov.
 */
public class SelfPersistedUser implements User {
    private PersistedUser persistedUser;
    private UserJpaRepository repository;

    SelfPersistedUser(PersistedUser persistedUser, UserJpaRepository repository) {
        this.persistedUser = persistedUser;
        this.repository = repository;
    }

    @Override
    public String getFirstName() {
        return persistedUser.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        persistedUser.setFirstName(firstName);
        persistedUser.setUpdateDate(new Date());
        repository.save(persistedUser);
    }

    @Override
    public String getMiddleName() {
        return persistedUser.getMiddleName();
    }

    @Override
    public void setMiddleName(String middleName) {
        persistedUser.setMiddleName(middleName);
        persistedUser.setUpdateDate(new Date());
        repository.save(persistedUser);
    }

    @Override
    public String getLastName() {
        return persistedUser.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        persistedUser.setLastName(lastName);
        persistedUser.setUpdateDate(new Date());
        repository.save(persistedUser);
    }

    @Override
    public Date getBirthDate() {
        return persistedUser.getBirthDate();
    }

    @Override
    public void setBirthDate(Date birthDate) {
        persistedUser.setBirthDate(birthDate);
        persistedUser.setUpdateDate(new Date());
        repository.save(persistedUser);
    }

    @Override
    public String getEmail() {
        return persistedUser.getEmail();
    }

    @Override
    public void setEmail(String email) {
        persistedUser.setEmail(email);
        persistedUser.setUpdateDate(new Date());
        repository.save(persistedUser);
    }

    @Override
    public String getLogin() {
        return persistedUser.getLogin();
    }

    @Override
    public String getPassword() {
        return persistedUser.getPassword();
    }

    @Override
    public boolean isLoggedIn() {
        return persistedUser.isLoggedIn();
    }

    @Override
    public void setLoggedIn(boolean loggedIn) {
        persistedUser.setLoggedIn(loggedIn);
        persistedUser.setUpdateDate(new Date());
        repository.save(persistedUser);
    }

    @Override
    public Date getRegisterDate() {
        return persistedUser.getRegisterDate();
    }

    @Override
    public Date getUpdateDate() {
        return persistedUser.getUpdateDate();
    }

    @Override
    public void delete() {
        repository.delete(persistedUser);
        persistedUser = new DeletedPersistedUser();
    }
}
