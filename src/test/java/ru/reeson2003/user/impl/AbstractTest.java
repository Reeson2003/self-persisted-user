package ru.reeson2003.user.impl;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import ru.reeson2003.user.api.Users;

/**
 * Date: 03.09.2017.
 * Time: 16:41.
 *
 * @author Pavel Gavrilov.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:test-context.xml")
@TransactionConfiguration(transactionManager="transactionManager")
public abstract class AbstractTest extends Assert {
    @Autowired
    Users users;
}
