package ru.reeson2003.user.caching;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.reeson2003.user.api.User;
import ru.reeson2003.user.api.Users;
import ru.reeson2003.user.exception.CreateUserException;
import ru.reeson2003.user.impl.AbstractTest;


import javax.transaction.Transactional;

public class CachedUsersTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CachedUsersTest.class);

    @Test
    @Transactional
    @Ignore
    public void performanceBoostTest() throws CreateUserException {
        int times = 1_000_000;
        final String login = "Tommy";
        final String password = "11223344";
        final String email = "tommy@mail.ru";
        final String login1 = "Franky";
        final String password1 = "000000";
        final String email1 = "farnky@mail.ru";
        Users cached = new CachedUsersImpl(users);
        User uncachedUser = users.newUser(login1, password1).email(email1).build();
        User cachedUser = cached.newUser(login, password).email(email).build();
        long uncacedTime = testPerformance(uncachedUser, times);
        long cachedTime = testPerformance(cachedUser, times);
        assertThat(cachedTime,lessThan(uncacedTime));
        LOGGER.debug("Uncached time: " + uncacedTime);
        LOGGER.debug("Cached   time: " + cachedTime);
    }

    private Matcher<? super Long> lessThan(final long expected) {
        return new BaseMatcher<Long>() {
            private long actual;
            @Override
            public boolean matches(Object item) {
                actual = (Long) item;
                return actual < expected;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("<" + actual + "> less than <" + expected + ">");
            }
        };
    }

    private long testPerformance(User user, int times) {
        long start = System.nanoTime();
        String email = user.getEmail();
        for (int j = 0; j < 10; j++) {
            long before = System.nanoTime();
            for (int i = 0; i < times; i++) {
                email = user.getEmail();
            }
            System.out.println(email);
            long after = System.nanoTime();
            LOGGER.debug("Iteration [" + j + "], time [" + (after - before) + "]");
        }
        LOGGER.debug("==================");
        return System.nanoTime() - start;
    }
}
