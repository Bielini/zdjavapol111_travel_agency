package pl.sda.zdjavapol111_travel_agency.service;

import pl.sda.zdjavapol111_travel_agency.model.Tour;

import java.util.List;

public interface TourService {

    void save(Tour tour);

    void save(Tour tour, String destinationCityName, String originCityName,
              String originAirportName, String destinationAirportName,
              String hotelName);

    List<Tour> getAllTours();

    void deleteById(Integer id);

    Tour getById(Integer id);

    List<Tour> get2PromotedTours();

    List<Tour> getToursByDurationTime(Integer duration);

    List<Tour> getToursByDestCity(String name);

    List<Tour> getToursByOriginCity(String name);

    List<Tour> filterTours(String searchField, String filter);

    void updatePromById(Integer id, Boolean newProm);
  
    String getActiveFilter(String searchField, String filter);

}
