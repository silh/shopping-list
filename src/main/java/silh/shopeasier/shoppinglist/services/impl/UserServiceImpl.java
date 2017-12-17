package silh.shopeasier.shoppinglist.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import silh.shopeasier.shoppinglist.converters.UserConverter;
import silh.shopeasier.shoppinglist.entities.users.User;
import silh.shopeasier.shoppinglist.exceptions.create.EmptyLoginException;
import silh.shopeasier.shoppinglist.exceptions.create.EmptyPasswordException;
import silh.shopeasier.shoppinglist.exceptions.create.LoginAlreadyInUseException;
import silh.shopeasier.shoppinglist.exceptions.create.LoginTooLongException;
import silh.shopeasier.shoppinglist.repositories.UserRepository;
import silh.shopeasier.shoppinglist.rest.dto.UserDto;
import silh.shopeasier.shoppinglist.services.UserService;

import javax.annotation.Nonnull;
import javax.transaction.Transactional;

import static java.util.Objects.requireNonNull;
import static silh.shopeasier.shoppinglist.utils.Utils.checkAndThrow;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    @Nonnull
    public User getUserByLogin(@Nonnull String login) {
        return userRepository.findUserByLogin(login);
    }

    @Nonnull
    @Override
    public User createUser(@Nonnull UserDto userTO) {
        String login = userTO.getLogin();
        String password = userTO.getPassword();
        checkAndThrow(StringUtils.isEmpty(login), EmptyLoginException::new);
        checkAndThrow(login.length() > 20, LoginTooLongException::new);
        checkAndThrow(StringUtils.isEmpty(password), EmptyPasswordException::new);

        Boolean loginUnique = userRepository.isLoginUnique(login);
        checkAndThrow(!loginUnique, () -> new LoginAlreadyInUseException(login));

        User user = requireNonNull(userConverter.toEntity(userTO)); //To avoid compilation warning
        return userRepository.save(user);
    }
}
