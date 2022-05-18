package pl.sda.zdjavapol111_travel_agency.service;

import pl.sda.zdjavapol111_travel_agency.model.User;

import java.util.List;

public interface UserService {
    void saveAdmin(User user);
    boolean existsByUsername(String username);

    List<User> findAll();

    void deleteById(Integer id);
}
