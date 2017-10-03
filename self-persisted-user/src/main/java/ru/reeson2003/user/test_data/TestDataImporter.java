package ru.reeson2003.user.test_data;

import ru.reeson2003.user.api.Users;
import ru.reeson2003.user.exception.CreateUserException;
import ru.reeson2003.user.util.UsersProvider;

/**
 * @author Pavel Gavrilov
 *         03.10.2017.
 */
public class TestDataImporter {
    public static void main(String[] args) {
        Users users = UsersProvider.getUsers();
        try {
            users.newUser("mickey", "12345")
                    .firstName("Mickey")
                    .lastName("O'Neil")
                    .email("mickey@snatch.com")
                    .build();
        } catch (CreateUserException e) {
        }
        try {
            users.newUser("tommy", "12345")
                    .firstName("Tommy")
                    .email("tommy@snatch.com")
                    .build();
        } catch (CreateUserException e) {
        }
        try {
            users.newUser("tony", "12345")
                    .firstName("Tony")
                    .lastName("Bullet-Tooth")
                    .email("tony@snatch.com")
                    .build();
        } catch (CreateUserException e) {
        }
        try {
            users.newUser("boris", "12345")
                    .firstName("Boris")
                    .middleName("The")
                    .lastName("Blade")
                    .email("boris@snatch.com")
                    .build();
        } catch (CreateUserException e) {
        }
        try {
            users.newUser("turkish", "12345")
                    .firstName("Turkish")
                    .email("turkish@snatch.com")
                    .build();
        } catch (CreateUserException e) {
        }
        try {
            users.newUser("mickey", "12345")
                    .firstName("Mickey")
                    .lastName("O'Neil")
                    .email("mickey@snatch.com")
                    .build();
        } catch (CreateUserException e) {
        }
        try {
            users.newUser("farnky", "12345")
                    .firstName("Franky")
                    .middleName("Four")
                    .lastName("Fingers")
                    .email("farnky@snatch.com")
                    .build();
        } catch (CreateUserException e) {
        }
        try {
            users.newUser("brick", "12345")
                    .firstName("Brick")
                    .lastName("Top")
                    .email("brick@snatch.com")
                    .build();
        } catch (CreateUserException e) {
        }
    }
}
