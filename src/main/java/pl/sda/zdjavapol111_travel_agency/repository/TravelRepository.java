package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public class TravelRepository extends JpaRepository <Travel, Integer> {
    Travel findById(Integer id);
}
