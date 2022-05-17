package pl.sda.zdjavapol111_travel_agency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol111_travel_agency.model.User;
import pl.sda.zdjavapol111_travel_agency.repository.RoleRepository;
import pl.sda.zdjavapol111_travel_agency.repository.UserRepository;
import pl.sda.zdjavapol111_travel_agency.service.UserService;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveAdmin(User user) {
        user.setPassword(getEncodedPassword(user.getPassword()));
        user.setRoles(Arrays.asList(roleRepository.findByName("ADMIN")));
        userRepository.save(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username is empty!");
        }
        return userRepository.existsByUsername(username);
    }

    private String getEncodedPassword(String rawPassword) {
        return bCryptPasswordEncoder.encode(rawPassword);
    }
}
