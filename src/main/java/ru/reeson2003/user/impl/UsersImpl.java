package ru.reeson2003.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.reeson2003.user.api.User;
import ru.reeson2003.user.api.UserBuilder;
import ru.reeson2003.user.api.Users;
import ru.reeson2003.user.persist.UserJpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Date: 31.08.2017.
 * Time: 22:41.
 *
 * @author Pavel Gavrilov.
 */
@Service
public class UsersImpl implements Users {
    @Autowired
    private UserJpaRepository repository;

    @Override
    public UserBuilder newUser(String login, String password) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    private class UserBuilderImpl implements UserBuilder {
        private String firstName;
        private String middleName;
        private String lastName;
        private Date birthDate;
        private String email;
        private String login;
        private String password;
        private Date registerDate;
        private Date updateDate;
        private boolean loggedIn;

        public UserBuilderImpl(String login, String password) {
            this.login = login;
            this.password = password;
        }

        @Override
        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public UserBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        @Override
        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public UserBuilder birthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        @Override
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        @Override
        public UserBuilder loggedIn(boolean loggedIn) {
            this.loggedIn = loggedIn;
            return this;
        }

        @Override
        public User build() {
            this.registerDate = new Date();
            this.updateDate = new Date();
            return null;
        }
    }
}
