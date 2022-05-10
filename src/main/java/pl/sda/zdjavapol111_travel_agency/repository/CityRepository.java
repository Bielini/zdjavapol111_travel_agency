package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public class CityRepository extends JpaRepository<City, Integer> {
    City findById(Integer id);
    City findByName(String name);
}
