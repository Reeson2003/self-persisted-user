package ru.reeson2003.user.caching;

import ru.reeson2003.user.api.User;
import ru.reeson2003.user.api.UserBuilder;

import java.util.Date;
import java.util.Map;

/**
 * Date: 05.09.2017.
 * Time: 20:24.
 *
 * @author Pavel Gavrilov.
 */
public class CachedUserBuilder implements UserBuilder {
    private UserBuilder userBuilder;
    private Map<String, User> cache;

    CachedUserBuilder(UserBuilder userBuilder, Map<String, User> cache) {
        this.userBuilder = userBuilder;
        this.cache = cache;
    }

    @Override
    public UserBuilder firstName(String firstName) {
        this.userBuilder = userBuilder.firstName(firstName);
        return this;
    }

    @Override
    public UserBuilder middleName(String middleName) {
        this.userBuilder = userBuilder.middleName(middleName);
        return this;
    }

    @Override
    public UserBuilder lastName(String lastName) {
        this.userBuilder = userBuilder.lastName(lastName);
        return this;
    }

    @Override
    public UserBuilder birthDate(Date birthDate) {
        this.userBuilder = userBuilder.birthDate(birthDate);
        return this;
    }

    @Override
    public UserBuilder email(String email) {
        this.userBuilder = userBuilder.email(email);
        return this;
    }

    @Override
    public UserBuilder loggedIn(boolean loggedIn) {
        this.userBuilder = userBuilder.loggedIn(loggedIn);
        return this;
    }

    @Override
    public User build() {
        return new CachedUserImpl(userBuilder.build(), cache);
    }
}
