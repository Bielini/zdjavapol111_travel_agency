package pl.sda.zdjavapol111_travel_agency.repository;

public class UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    boolean existsByUsername (String username);
}
