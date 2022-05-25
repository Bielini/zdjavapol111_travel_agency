package pl.sda.zdjavapol111_travel_agency.service;

import pl.sda.zdjavapol111_travel_agency.model.BoughtTour;
import pl.sda.zdjavapol111_travel_agency.model.Tour;

import java.util.List;

public interface BoughtTourService {

    Tour getById(Long id);

    void save(BoughtTour boughtTour);

    List<BoughtTour> findAll();

//    String getCityNameById(Integer id);
//
//    String getAirportNameById(Integer id);
//
//    String getHotelNameById(Integer id);
//
//    LocalDate getStartDateById(Long id);
//
//    LocalDate getEndDateById(Long id);
//
//    Integer getAdultSeatsById(Long id);
//
//    Integer getMinorSeatsById(Long id);
//
//    BigDecimal getAdultPriceById(Long id);
//
//    BigDecimal getMinorPriceById(Long id);
//
//    BigDecimal getEndPriceById(Long id);





//    void showName(City name);
//
//    List<Tour> getAll();
//
//    void save(BoughtTour boughtTour);
}
