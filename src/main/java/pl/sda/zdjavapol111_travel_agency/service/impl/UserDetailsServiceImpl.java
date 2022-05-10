package pl.sda.zdjavapol111_travel_agency.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class UserDetailsServiceImpl implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User userFromDB = userRepository.findByUsername(username);

        if (userFromDB == null) {
            throw new UsernameNotFoundException("Username " + username + " not found in database!");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(userFromDB.getUsername())
                .password(userFromDB.getPassword())
                .roles(userFromDB.getRoles()
                        .stream()
                        .map(u -> u.getName())
                        .collect(Collectors.joining()))
                .build();
    }
}
