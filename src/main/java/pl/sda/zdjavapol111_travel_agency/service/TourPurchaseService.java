package pl.sda.zdjavapol111_travel_agency.service;

import pl.sda.zdjavapol111_travel_agency.model.Tour;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface TourPurchaseService {

    Tour getById(Long id);

    String getCityNameById(Integer id);

    String getAirportNameById(Integer id);

    String getHotelNameById(Integer id);

    LocalDate getStartDateById(Long id);

    LocalDate getEndDateById(Long id);

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