package pl.sda.zdjavapol111_travel_agency.service;

import pl.sda.zdjavapol111_travel_agency.model.BoughtTour;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.model.TourSketch;

import java.util.List;

public interface TourService {

    void save(Tour tour);

    void save(Tour tour, String destinationCityName, String originCityName,
              String originAirportName, String destinationAirportName,
              String hotelName);

    void update(Integer id, TourSketch tourNewSketch);

    List<Tour> getAllTours();

    void deleteById(Integer id);

    Tour getById(Integer id);

    List<Tour> get3PromotedTours();
    List<Tour> get3ComingTours();

    List<Tour> filterTours(String searchField, String filter);

    void updatePromById(Integer id, Boolean newProm);

    String getActiveFilter(String searchField, String filter);

    List<Tour> sortTours(String sort, List<Tour> filteredTours);

    void save(Tour tour, BoughtTour boughtTour);
}
