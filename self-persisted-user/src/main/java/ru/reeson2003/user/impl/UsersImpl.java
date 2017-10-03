package ru.reeson2003.user.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.reeson2003.user.api.User;
import ru.reeson2003.user.api.UserBuilder;
import ru.reeson2003.user.api.Users;
import ru.reeson2003.user.exception.CreateUserException;
import ru.reeson2003.user.exception.SearchUserException;
import ru.reeson2003.user.persist.PersistedUser;
import ru.reeson2003.user.persist.UserJpaRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Date: 31.08.2017.
 * Time: 22:41.
 *
 * @author Pavel Gavrilov.
 */
@Service
public class UsersImpl implements Users {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersImpl.class);
    private final UserJpaRepository repository;

    @Autowired
    public UsersImpl(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserBuilder newUser(String login, String password) throws CreateUserException{
        return new UserBuilderImpl(login, password);
    }

    @Override
    public List<User> getUsers() {
        return getAllUsers(repository.findAll());
    }

    @Override
    public User findOne(String login) throws SearchUserException {
        PersistedUser persistedUser = repository.findByLogin(login);
        if (persistedUser != null)
            return new SelfPersistedUser(persistedUser, repository);
        else
            throw new SearchUserException();
    }

    private List<User> getAllUsers(List<PersistedUser> persistedUsers) {
        List<User> result = new ArrayList<>(persistedUsers.size());
        for (PersistedUser persistedUser : persistedUsers) {
            result.add(new SelfPersistedUser(persistedUser, repository));
        }
        return result;
    }

    private class UserBuilderImpl implements UserBuilder {
        private PersistedUser persistedUser;

        UserBuilderImpl(String login, String password) throws CreateUserException{
            PersistedUser persistedUser = repository.findByLogin(login);
            if (persistedUser != null)
                throw new CreateUserException("Login [" + login + "] already exists");
            else {
                persistedUser = new PersistedUser();
                persistedUser.setLogin(login);
                persistedUser.setPassword(password);
                repository.save(persistedUser);
                this.persistedUser = persistedUser;
            }
        }

        @Override
        public UserBuilder firstName(String firstName) {
            persistedUser.setFirstName(firstName);
            return this;
        }

        @Override
        public UserBuilder middleName(String middleName) {
            persistedUser.setMiddleName(middleName);
            return this;
        }

        @Override
        public UserBuilder lastName(String lastName) {
            persistedUser.setLastName(lastName);
            return this;
        }

        @Override
        public UserBuilder birthDate(Date birthDate) {
            persistedUser.setBirthDate(birthDate);
            return this;
        }

        @Override
        public UserBuilder email(String email) {
            persistedUser.setEmail(email);
            return this;
        }

        @Override
        public UserBuilder loggedIn(boolean loggedIn) {
            persistedUser.setLoggedIn(loggedIn);
            return this;
        }

        @Override
        public User build() {
            Date now = new Date();
            persistedUser.setUpdateDate(now);
            persistedUser.setUpdateDate(now);
            repository.save(persistedUser);
            return new SelfPersistedUser(persistedUser, repository);
        }
    }
}
