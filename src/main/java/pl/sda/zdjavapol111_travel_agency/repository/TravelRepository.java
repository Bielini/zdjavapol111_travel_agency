package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.zdjavapol111_travel_agency.model.Tour;

public class TravelRepository extends JpaRepository <Tour, Integer> {
    Tour findById(Integer id);
}
