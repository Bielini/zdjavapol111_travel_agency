package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.zdjavapol111_travel_agency.model.Hotel;

public class HotelRepository extends JpaRepository <Hotel, Integer> {
    Hotel findById(Integer id);

}