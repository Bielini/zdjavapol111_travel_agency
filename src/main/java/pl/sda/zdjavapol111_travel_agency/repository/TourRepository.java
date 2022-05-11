package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TourRepository<Travel> extends JpaRepository <Tour, Long> {

}
