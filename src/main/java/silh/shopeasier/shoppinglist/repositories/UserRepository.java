package silh.shopeasier.shoppinglist.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import silh.shopeasier.shoppinglist.entities.users.User;

import javax.annotation.Nonnull;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByLogin(String login);

    @Query("SELECT (count(login) = 0) FROM User WHERE login = :login")
    Boolean isLoginUnique(@Nonnull @Param("login") String login);
}
