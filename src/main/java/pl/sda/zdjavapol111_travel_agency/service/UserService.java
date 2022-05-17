package pl.sda.zdjavapol111_travel_agency.service;

import pl.sda.zdjavapol111_travel_agency.model.User;

public interface UserService {
    void saveAdmin(User user);
    boolean existsByUsername(String username);
}
