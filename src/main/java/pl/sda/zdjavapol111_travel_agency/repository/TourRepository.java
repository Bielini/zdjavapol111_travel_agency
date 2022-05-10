package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.zdjavapol111_travel_agency.model.Tour;

public interface TourRepository<Travel> extends JpaRepository <Tour, Long> {
    Tour findById(Integer id);
}
