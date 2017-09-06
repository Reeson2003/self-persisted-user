package ru.reeson2003.user.caching;

import ru.reeson2003.user.api.User;

import java.util.Date;
import java.util.Map;

/**
 * Date: 05.09.2017.
 * Time: 19:50.
 *
 * @author Pavel Gavrilov.
 */
public class CachedUserImpl implements User {
    private User origin;
    private Map<String, User>  cache;

    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String login;
    private String password;
    private boolean loggedIn;
    private Date registerDate;
    private Date updateDate;


    public CachedUserImpl(User origin, Map<String, User> cache) {
        this.origin = origin;
        this.cache = cache;
        actualize();
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        origin.setFirstName(firstName);
        actualize();
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }

    @Override
    public void setMiddleName(String middleName) {
        origin.setMiddleName(middleName);
        actualize();
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        origin.setLastName(lastName);
        actualize();
    }

    @Override
    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(Date birthDate) {
        origin.setBirthDate(birthDate);
        actualize();
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        origin.setEmail(email);
        actualize();
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isLoggedIn() {
        return loggedIn;
    }

    @Override
    public void setLoggedIn(boolean loggedIn) {
        origin.setLoggedIn(loggedIn);
        actualize();
    }

    @Override
    public Date getRegisterDate() {
        return registerDate;
    }

    @Override
    public Date getUpdateDate() {
        return updateDate;
    }

    @Override
    public void delete() {
        origin.delete();
        cache.remove(login);
    }

    private void actualize() {
        this.firstName = origin.getFirstName();
        this.middleName = origin.getMiddleName();
        this.lastName = origin.getLastName();
        this.birthDate = origin.getBirthDate();
        this.email = origin.getEmail();
        this.login = origin.getLogin();
        this.password = origin.getPassword();
        this.loggedIn = origin.isLoggedIn();
        this.registerDate = origin.getRegisterDate();
        this.updateDate = origin.getUpdateDate();
        cache.put(login, this);
    }
}
