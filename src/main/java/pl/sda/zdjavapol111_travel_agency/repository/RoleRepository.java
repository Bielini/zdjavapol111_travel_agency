package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.zdjavapol111_travel_agency.model.Role;

public class RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
