package ru.reeson2003.user.test_data;

import ru.reeson2003.user.util.UsersProvider;

/**
 * @author Pavel Gavrilov
 *         03.10.2017.
 */
public class TestDataRemover {
    public static void main(String[] args) {
        UsersProvider.getUsers().getUsers().forEach(u -> u.delete());
    }
}
