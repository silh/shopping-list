package silh.shopeasier.shoppinglist.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import silh.shopeasier.shoppinglist.entities.users.User;
import silh.shopeasier.shoppinglist.repositories.UserRepository;

import java.util.Collections;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(username);
        if (user == null) {
            String message = String.format("User %s was not found", username);
            throw new UsernameNotFoundException(message);
        }

        //We don't need admin or any other kind of roles
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
