package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public class ContinentRepository extends JpaRepository <Continent, Integer>{
    Continent findById(Integer id);
}
