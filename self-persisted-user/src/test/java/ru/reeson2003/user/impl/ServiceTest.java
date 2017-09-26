package ru.reeson2003.user.impl;

import org.junit.Test;
import ru.reeson2003.user.api.Users;
import ru.reeson2003.user.util.UsersProvider;

/**
 * Date: 03.09.2017.
 * Time: 18:15.
 *
 * @author Pavel Gavrilov.
 */
public class ServiceTest extends AbstractTest {
    @Test
    public void wiringTest() {
        assertNotNull("Users is null", users);
    }

    @Test
    public void userProviderTest() {
        Users users = UsersProvider.getUsers();
        assertNotNull("Users is null", users);
    }
}
