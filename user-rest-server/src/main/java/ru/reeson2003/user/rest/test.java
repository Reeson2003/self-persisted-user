package ru.reeson2003.user.rest;

import ru.reeson2003.user.api.User;
import ru.reeson2003.user.api.Users;
import ru.reeson2003.user.exception.CreateUserException;
import ru.reeson2003.user.exception.SearchUserException;
import ru.reeson2003.user.util.UsersProvider;

/**
 * Created by Pavel Gavrilov on 26.09.2017.
 */
public class test {
    public static void main(String[] args) throws CreateUserException, SearchUserException {
        Users users = UsersProvider.getUsers();
        User user = users.newUser("Vasya", "Pupkin").build();
        User vasya = users.findOne("Vasya");
        System.out.println(vasya.getRegisterDate());
    }
}
