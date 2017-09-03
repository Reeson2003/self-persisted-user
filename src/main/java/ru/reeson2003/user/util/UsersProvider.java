package ru.reeson2003.user.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.reeson2003.user.api.Users;

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
}
