package silh.shopeasier.shoppinglist.services;

import silh.shopeasier.shoppinglist.entities.users.User;
import silh.shopeasier.shoppinglist.rest.dto.UserDto;

import javax.annotation.Nonnull;

public interface UserService {
    @Nonnull
    User getUserByLogin(@Nonnull String login);

    @Nonnull
    User createUser(@Nonnull UserDto userTO);
}
