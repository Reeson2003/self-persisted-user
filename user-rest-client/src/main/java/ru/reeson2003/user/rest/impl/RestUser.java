package ru.reeson2003.user.rest.impl;

import ru.reeson2003.user.api.User;
import ru.reeson2003.user.exception.DeletedUserException;
import ru.reeson2003.user.rest.client.service.RestClientService;
import ru.reeson2003.user.rest.client.stub.UserStub;

import java.util.Date;

/**
 * Created by Pavel Gavrilov on 29.09.2017.
 */
public class RestUser implements User {
    private String login;
    private RestClientService restClientService;

    public RestUser(User user, RestClientService restClientService) {
        this.login = user.getLogin();
        this.restClientService = restClientService;
        restClientService.updateUser(user);
    }

    @Override
    public String getFirstName() {
        return getOrigin().getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        UserStub userStub = new UserStub(getOrigin());
        userStub.setFirstName(firstName);
        restClientService.updateUser(userStub);
    }

    @Override
    public String getMiddleName() {
        return getOrigin().getMiddleName();
    }

    @Override
    public void setMiddleName(String middleName) {
        UserStub userStub = new UserStub(getOrigin());
        userStub.setMiddleName(middleName);
        restClientService.updateUser(userStub);
    }

    @Override
    public String getLastName() {
        return getOrigin().getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        UserStub userStub = new UserStub(getOrigin());
        userStub.setLastName(lastName);
        restClientService.updateUser(userStub);
    }

    @Override
    public Date getBirthDate() {
        return getOrigin().getBirthDate();
    }

    @Override
    public void setBirthDate(Date birthDate) {
        UserStub userStub = new UserStub(getOrigin());
        userStub.setBirthDate(birthDate);
        restClientService.updateUser(userStub);
    }

    @Override
    public String getEmail() {
        return getOrigin().getEmail();
    }

    @Override
    public void setEmail(String email) {
        UserStub userStub = new UserStub(getOrigin());
        userStub.setEmail(email);
        restClientService.updateUser(userStub);
    }

    @Override
    public String getLogin() {
        return getOrigin().getLogin();
    }

    @Override
    public String getPassword() {
        return getOrigin().getPassword();
    }

    @Override
    public boolean isLoggedIn() {
        return getOrigin().isLoggedIn();
    }

    @Override
    public void setLoggedIn(boolean loggedIn) {
        UserStub userStub = new UserStub(getOrigin());
        userStub.setLoggedIn(loggedIn);
        restClientService.updateUser(userStub);
    }

    @Override
    public Date getRegisterDate() {
        return getOrigin().getRegisterDate();
    }

    @Override
    public Date getUpdateDate() {
        return getOrigin().getUpdateDate();
    }

    @Override
    public void delete() {
        restClientService.deleteUser(login);
    }

    private User getOrigin() {
        User user = restClientService.getByLogin(login);
        if (user == null)
            throw new DeletedUserException();
        return user;
    }
}
