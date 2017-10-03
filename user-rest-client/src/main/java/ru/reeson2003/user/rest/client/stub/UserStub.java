package ru.reeson2003.user.rest.client.stub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.reeson2003.user.api.User;

import java.util.Date;

/**
 * Created by Pavel Gavrilov on 27.09.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserStub implements User {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String login;
    private String password;
    private Date registerDate;
    private Date updateDate;
    private boolean loggedIn;

    public UserStub() {
    }

    public UserStub(User user) {
        this.firstName = user.getFirstName();
        this.middleName = user.getMiddleName();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDate();
        this.email = user.getEmail();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.registerDate = user.getRegisterDate();
        this.updateDate = user.getUpdateDate();
        this.loggedIn = user.isLoggedIn();
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }

    @Override
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean isLoggedIn() {
        return loggedIn;
    }

    @Override
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public void delete() {

    }

    @Override
    public String toString() {
        return "UserStub{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", registerDate=" + registerDate +
                ", updateDate=" + updateDate +
                ", loggedIn=" + loggedIn +
                '}';
    }
}
