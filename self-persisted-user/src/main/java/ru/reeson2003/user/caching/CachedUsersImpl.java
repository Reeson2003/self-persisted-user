package ru.reeson2003.user.caching;

import ru.reeson2003.user.api.User;
import ru.reeson2003.user.api.UserBuilder;
import ru.reeson2003.user.api.Users;
import ru.reeson2003.user.exception.CreateUserException;
import ru.reeson2003.user.exception.SearchUserException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Date: 05.09.2017.
 * Time: 19:42.
 *
 * @author Pavel Gavrilov.
 */
public class CachedUsersImpl implements Users {
    private Users users;
    private Map<String, User> cache = new HashMap<>();

    public CachedUsersImpl(Users users) {
        this.users = users;
    }

    @Override
    public UserBuilder newUser(String login, String password) throws CreateUserException {
        return new CachedUserBuilder(users.newUser(login, password), cache);
    }

    @Override
    public List<User> getUsers() {
        return users.getUsers()
                .stream()
                .map(x -> wrapCached(x, cache))
                .collect(Collectors.toList());
    }

    @Override
    public User findOne(String login) throws SearchUserException {
        if (cache.containsKey(login))
            return cache.get(login);
        else {
            User user = users.findOne(login);
            return wrapCached(user, cache);
        }
    }

    private User wrapCached(User origin, Map<String, User> cache) {
        return new CachedUserImpl(origin, cache);
    }
}
