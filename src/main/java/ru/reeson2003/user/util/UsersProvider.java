package ru.reeson2003.user.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.reeson2003.user.api.Users;
import ru.reeson2003.user.caching.CachedUsersImpl;

/**
 * Date: 03.09.2017.
 * Time: 18:09.
 *
 * @author Pavel Gavrilov.
 */
public class UsersProvider {
    private static Users users = new ClassPathXmlApplicationContext("user-persist-context.xml").getBean(Users.class);

    public static Users getUsers() {
        return users;
    }

    public static Users getCachingUsers(Users users) {
        return new CachedUsersImpl(users);
    }
}
