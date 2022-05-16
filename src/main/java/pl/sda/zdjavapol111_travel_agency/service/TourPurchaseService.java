package pl.sda.zdjavapol111_travel_agency.service;

import pl.sda.zdjavapol111_travel_agency.model.BoughtTour;
import pl.sda.zdjavapol111_travel_agency.model.City;
import pl.sda.zdjavapol111_travel_agency.model.Tour;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface TourPurchaseService {

    Tour getById(Long id);

    String getCityNameById(Integer id);

    String getAirportNameById(Integer id);

    String getHotelNameById(Integer id);

    LocalDate getDateFormById(Long id);

    LocalDate getDateToById(Long id);

    Integer getAdultSeatsById(Long id);

    Integer getMinorSeatsById(Long id);

    BigDecimal getAdultPriceById(Long id);

    BigDecimal getMinorPriceById(Long id);

    BigDecimal getEndPriceById(Long id);





//    void showName(City name);
//
//    List<Tour> getAll();
//
//    void save(BoughtTour boughtTour);
}
