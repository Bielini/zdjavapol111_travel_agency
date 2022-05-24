package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.zdjavapol111_travel_agency.model.BoughtTour;

@Repository
public interface BoughtTourRepository extends JpaRepository <BoughtTour, Integer> {
}
