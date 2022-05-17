package pl.sda.zdjavapol111_travel_agency.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol111_travel_agency.model.Airport;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.repository.AirportRepository;
import pl.sda.zdjavapol111_travel_agency.repository.CityRepository;
import pl.sda.zdjavapol111_travel_agency.repository.TourRepository;
import pl.sda.zdjavapol111_travel_agency.service.TourService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class TourServiceImpl implements TourService {

    @Autowired
    TourRepository tourRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    AirportRepository airportRepository;


    public void calculateDuration(Tour tour) {
        try {
            tour.setDurationTime(subtractDates(tour.getStartDate().toString(), tour.getEndDate().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setDestinationCity(Tour tour, String destinationCityName) {
        tour.setDestinationCity(cityRepository.findByName(destinationCityName));
    }

    public void setOriginCity(Tour tour, String originCityName) {
        tour.setOriginCity(cityRepository.findByName(originCityName));
    }

    public void setDestinationAirport(Tour tour, String destinationAirportName) {
        tour.setDestinationAirport(airportRepository.findByName(destinationAirportName));
    }

    public void setOriginAirport(Tour tour, String originAirportName) {
        tour.setOriginAirport(airportRepository.findByName(originAirportName));
    }


    private static Integer subtractDates(String stringStartDate, String stringEndDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse(stringStartDate);
        Date endDate = dateFormat.parse(stringEndDate);
        Double doubleResultOfSubtract = ((endDate.getTime() - startDate.getTime()) / 86400000.0);
        return doubleResultOfSubtract.intValue();
    }


    @Override
    public void save(Tour tour) {
        tourRepository.save(tour);
    }

    @Override
    public void save(Tour tour, String destinationCityName, String originCityName,
                     String originAirportName, String destinationAirportName) {
        this.calculateDuration(tour);
        this.setDestinationCity(tour, destinationCityName);
        this.setOriginCity(tour, originCityName);
        this.setOriginAirport(tour, originAirportName);
        this.setDestinationAirport(tour, destinationAirportName);
        tourRepository.save(tour);
    }

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        tourRepository.deleteById(id.longValue());
    }

    @Override
    public Tour getById(Integer id) {
        return tourRepository.getById(id.longValue());
    }

    @Override
    public List<Tour> get2PromotedTours() {
        List<Tour> allTours = tourRepository.findAll();

        List<Tour> promotedTours = new ArrayList<>();
        int counter = 0;

        for (Tour tour : allTours) {
            if (tour.getPromotion() && counter < 2) {
                promotedTours.add(tour);
                counter++;
            }
        }
        return promotedTours;
    }

    @Override
    public List<Tour> getToursByDurationTime(Integer duration) {
        return tourRepository.findAllToursByDurationTime(duration);
    }

    @Override
    public void updatePromById(Integer id, Boolean newProm) {
        tourRepository.updatePassById(id.longValue(),newProm);
    }

    @Override
    public List<Tour> getToursByDestCity(String name) {
        return tourRepository.findAllToursByDestinationCity(name);
    }

    @Override
    public List<Tour> getToursByOriginCity(String name) {
        return tourRepository.findAllToursByOriginCity(name);
    }

    public List<Tour> filterTours(String searchField, String filter) {

        switch (filter) {
            case "destinationCity":
                return tourRepository.findAllToursByDestinationCity(searchField);
            case "originCity":
                return tourRepository.findAllToursByOriginCity(searchField);
            case "durationTime":
                try {
                    return tourRepository.findAllToursByDurationTime(Integer.parseInt(searchField));
                } catch (IllegalArgumentException e) {
                    log.error("Thrown:" + e.getMessage());
                }
        }
        return Collections.emptyList();
    }

    public String getActiveFilter(String searchField, String filter){
        switch (filter) {
            case "destinationCity":
                return "Cel wycieczki: "+ searchField;
            case "originCity":
                return "Miasto wyjazdu: "+ searchField;
            case "durationTime":
                return "Czas trwania co najmniej: "+ searchField+" dni";
        }
        return "";
    }

}
