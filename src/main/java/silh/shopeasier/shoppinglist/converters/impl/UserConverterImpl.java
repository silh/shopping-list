package silh.shopeasier.shoppinglist.converters.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import silh.shopeasier.shoppinglist.converters.UserConverter;
import silh.shopeasier.shoppinglist.entities.users.User;
import silh.shopeasier.shoppinglist.rest.dto.UserDto;

import javax.annotation.Nullable;

@Service
public class UserConverterImpl implements UserConverter {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserConverterImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Nullable
    public UserDto fromEntity(@Nullable User user) {
        if (user == null) {
            return null;
        }

        UserDto userTO = new UserDto();
        userTO.setId(user.getId());
        userTO.setLogin(user.getLogin());
//        userTO.setPassword(user.getPassword());
        return userTO;
    }

    @Override
    @Nullable
    public User toEntity(@Nullable UserDto userTO) {
        if (userTO == null) {
            return null;
        }
        User user = new User();
        user.setId(userTO.getId());
        user.setLogin(userTO.getLogin());
        user.setPassword(passwordEncoder.encode(userTO.getPassword()));
        return user;
    }
}
