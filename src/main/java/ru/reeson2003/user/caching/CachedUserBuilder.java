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

    public CachedUserBuilder(UserBuilder userBuilder, Map<String, User> cache) {
        this.userBuilder = userBuilder;
        this.cache = cache;
    }

    @Override
    public UserBuilder firstName(String firstName) {
        return userBuilder.firstName(firstName);
    }

    @Override
    public UserBuilder middleName(String middleName) {
        return userBuilder.middleName(middleName);
    }

    @Override
    public UserBuilder lastName(String lastName) {
        return userBuilder.lastName(lastName);
    }

    @Override
    public UserBuilder birthDate(Date birthDate) {
        return userBuilder.birthDate(birthDate);
    }

    @Override
    public UserBuilder email(String email) {
        return userBuilder.email(email);
    }

    @Override
    public UserBuilder loggedIn(boolean loggedIn) {
        return userBuilder.loggedIn(loggedIn);
    }

    @Override
    public User build() {
        return new CachedUserImpl(userBuilder.build(), cache);
    }
}
