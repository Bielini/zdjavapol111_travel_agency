package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.zdjavapol111_travel_agency.model.Continent;

public class ContinentRepository extends JpaRepository <Continent, Integer>{
    Continent findById(Integer id);
}
