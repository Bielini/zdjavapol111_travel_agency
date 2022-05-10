package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.zdjavapol111_travel_agency.model.Country;

public class CountryRepository extends JpaRepository <Country, Integer>{
    Country findById(Integer id);

}