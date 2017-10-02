package ru.reeson2003.user.rest.impl;

import ru.reeson2003.user.api.User;
import ru.reeson2003.user.api.UserBuilder;
import ru.reeson2003.user.api.Users;
import ru.reeson2003.user.exception.CreateUserException;
import ru.reeson2003.user.exception.SearchUserException;
import ru.reeson2003.user.rest.client.service.RestClientService;
import ru.reeson2003.user.rest.client.stub.UserStub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pavel Gavrilov on 29.09.2017.
 */
public class RestUsers implements Users {
    private RestClientService restClientService;

    public RestUsers(String domain) {
        restClientService = new RestClientService(domain);
    }

    @Override
    public UserBuilder newUser(String login, String password) throws CreateUserException {
        return new RestUserBuilder(login, password);
    }

    @Override
    public List<User> getUsers() {
        return wrapUsers(restClientService.getAll());
    }

    @Override
    public User findOne(String login) throws SearchUserException {
        User user = restClientService.getByLogin(login);
        if (user == null)
            throw new SearchUserException();
        return wrapUser(user);
    }

    private List<User> wrapUsers(List<User> origins) {
        List<User> result = new ArrayList<>(origins.size());
        for (User o : origins) {
            result.add(wrapUser(o));
        }
//        return origins
//                .stream()
//                .map(this::wrapUser)
//                .collect(Collectors.toList());
        return result;
    }

    private User wrapUser(User user) {
        return new RestUser(user, new RestClientService(restClientService.getDomain()));
    }

    private class RestUserBuilder implements UserBuilder {
        private UserStub userStub;
        private RestUserBuilder(String login, String password) throws CreateUserException {
            if (!restClientService.addUser(login, password))
                throw new CreateUserException("Can't create user with login " + login);
            else {
                User user = restClientService.getByLogin(login);
                userStub = new UserStub();
                userStub.setLogin(user.getLogin());
                userStub.setPassword(user.getPassword());
            }
        }

        @Override
        public UserBuilder firstName(String firstName) {
            userStub.setFirstName(firstName);
            return this;
        }

        @Override
        public UserBuilder middleName(String middleName) {
            userStub.setMiddleName(middleName);
            return this;
        }

        @Override
        public UserBuilder lastName(String lastName) {
            userStub.setLastName(lastName);
            return this;
        }

        @Override
        public UserBuilder birthDate(Date birthDate) {
            userStub.setBirthDate(birthDate);
            return this;
        }

        @Override
        public UserBuilder email(String email) {
            userStub.setEmail(email);
            return this;
        }

        @Override
        public UserBuilder loggedIn(boolean loggedIn) {
            userStub.setLoggedIn(loggedIn);
            return this;
        }

        @Override
        public User build() {
            return new RestUser(userStub, new RestClientService(restClientService.getDomain()));
        }
    }
}
