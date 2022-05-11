package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.context.annotation.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
