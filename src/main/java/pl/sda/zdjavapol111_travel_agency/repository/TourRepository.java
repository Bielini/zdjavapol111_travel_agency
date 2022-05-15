package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.zdjavapol111_travel_agency.model.Tour;

import java.util.List;


@Repository
public interface TourRepository extends JpaRepository <Tour, Long> {

    @Query(value = "SELECT t FROM Tour t WHERE t.durationTime <= :duration")
    List<Tour> findAllToursByDurationTime(@Param(value = "duration") Integer duration);
    @Query(value = "SELECT t FROM Tour t WHERE t.destinationCity.name = :name")
    List<Tour> findAllToursByDestinationCity(@Param(value = "name")String name);
    @Query(value = "SELECT t FROM Tour t WHERE t.originCity.name = :name")
    List<Tour> findAllToursByOriginCity(@Param(value = "name")String name);

}

