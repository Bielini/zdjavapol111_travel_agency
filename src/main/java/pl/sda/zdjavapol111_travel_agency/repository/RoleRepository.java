package pl.sda.zdjavapol111_travel_agency.repository;

public class RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
