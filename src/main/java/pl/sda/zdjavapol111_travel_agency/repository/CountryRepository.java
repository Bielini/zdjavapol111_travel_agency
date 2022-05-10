package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public class CountryRepository extends JpaRepository <Country, Integer>{
    Country findById(Integer id);

}
