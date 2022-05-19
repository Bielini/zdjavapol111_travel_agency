package pl.sda.zdjavapol111_travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.zdjavapol111_travel_agency.model.Airport;
import pl.sda.zdjavapol111_travel_agency.model.City;
import pl.sda.zdjavapol111_travel_agency.model.Hotel;
import pl.sda.zdjavapol111_travel_agency.model.Tour;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    @Query(value = "SELECT t FROM Tour t WHERE t.durationTime <= :duration")
    List<Tour> findAllToursByDurationTime(@Param(value = "duration") Integer duration);

    @Query(value = "SELECT t FROM Tour t WHERE t.destinationCity.name = :name")
    List<Tour> findAllToursByDestinationCity(@Param(value = "name") String name);

    @Query(value = "SELECT t FROM Tour t WHERE t.originCity.name = :name")
    List<Tour> findAllToursByOriginCity(@Param(value = "name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Tour t SET t.promotion = :prom WHERE t.id = :id")
    void updatePromotionById(@Param(value = "id") Long id, @Param(value = "prom") Boolean newProm);

    @Modifying
    @Transactional
    @Query("UPDATE Tour t SET t.destinationCity = :new WHERE t.id = :id")
    void updateDestinationCityById(@Param(value = "id") Long id, @Param(value = "new") City destinationCity);

    @Modifying
    @Transactional
    @Query("UPDATE Tour t SET t.destinationAirport = :new WHERE t.id = :id")
    void updateDestinationAirportById(@Param(value = "id") Long id, @Param(value = "new") Airport destinationAirport);

    @Modifying
    @Transactional
    @Query("UPDATE Tour t SET t.destinationHotel = :new WHERE t.id = :id")
    void updateDestinationHotelById(@Param(value = "id") Long id, @Param(value = "new") Hotel destinationHotel);

    @Modifying
    @Transactional
    @Query("UPDATE Tour t SET t.originCity = :new WHERE t.id = :id")
    void updateOriginCityById(@Param(value = "id") Long id, @Param(value = "new") City originCity);

    @Modifying
    @Transactional
    @Query("UPDATE Tour t SET t.originAirport = :new WHERE t.id = :id")
    void updateOriginAirportById(@Param(value = "id") Long id, @Param(value = "new") Airport originAirport);

    @Modifying
    @Transactional
    @Query("UPDATE Tour t SET t.startDate = :new WHERE t.id = :id")
    void updateStartDateById(@Param(value = "id") Long id, @Param(value = "new") LocalDate startDate);

    @Modifying
    @Transactional
    @Query("UPDATE Tour t SET t.endDate = :new WHERE t.id = :id")
    void updateEndDateById(@Param(value = "id") Long id, @Param(value = "new") LocalDate endDate);

    @Modifying
    @Transactional
    @Query("UPDATE Tour t SET t.durationTime = :new WHERE t.id = :id")
    void updateDurationById(@Param(value = "id") Long id, @Param(value = "new") Integer duration);

    @Modifying
    @Transactional
    @Query("UPDATE Tour t SET t.adultPrice = :new WHERE t.id = :id")
    void updateAdultPriceById(@Param(value = "id") Long id, @Param(value = "new") BigDecimal adultPrice);

    @Modifying
    @Transactional
    @Query("UPDATE Tour t SET t.minorPrice = :new WHERE t.id = :id")
    void updateMinorPriceById(@Param(value = "id") Long id, @Param(value = "new") BigDecimal minorPrice);

    @Modifying
    @Transactional
    @Query("UPDATE Tour t SET t.adultSeats = :new WHERE t.id = :id")
    void updateAdultSeatsById(@Param(value = "id") Long id, @Param(value = "new") Integer adultSeats);

    @Modifying
    @Transactional
    @Query("UPDATE Tour t SET t.minorSeats = :new WHERE t.id = :id")
    void updateMinorSeatsById(@Param(value = "id") Long id, @Param(value = "new") Integer minorSeats);


}
