package ru.reeson2003.user.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Date: 27.08.2017.
 * Time: 21:28.
 *
 * @author Pavel Gavrilov.
 */
@Repository
public interface UserJpaRepository extends JpaRepository<PersistedUser, Long> {
    PersistedUser findByLogin(String login);
}
