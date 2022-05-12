package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.zdjavapol111_travel_agency.model.Tour;

@Repository
public interface TourRepository extends JpaRepository <Tour, Long> {

}
