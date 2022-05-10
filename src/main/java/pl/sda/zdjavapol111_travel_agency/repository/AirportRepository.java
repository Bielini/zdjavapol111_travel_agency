package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.zdjavapol111_travel_agency.model.Airport;

public class AirportRepository extends JpaRepository<Airport, Integer> {
    Airport findById(Integer id);
}
