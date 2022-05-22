package pl.sda.zdjavapol111_travel_agency.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.model.TourSketch;
import pl.sda.zdjavapol111_travel_agency.repository.AirportRepository;
import pl.sda.zdjavapol111_travel_agency.repository.CityRepository;
import pl.sda.zdjavapol111_travel_agency.repository.HotelRepository;
import pl.sda.zdjavapol111_travel_agency.repository.TourRepository;
import pl.sda.zdjavapol111_travel_agency.service.TourService;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import java.util.stream.Collectors;

@Slf4j
@Service
public class TourServiceImpl implements TourService {

    @Autowired
    TourRepository tourRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    HotelRepository hotelRepository;


    private void calculateAndSetDuration(Tour tour) {
        try {
            tour.setDurationTime(subtractDates(tour.getStartDate().toString(), tour.getEndDate().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void setDestinationCity(Tour tour, String destinationCityName) {
        tour.setDestinationCity(cityRepository.findByName(destinationCityName));
    }

    private void setOriginCity(Tour tour, String originCityName) {
        tour.setOriginCity(cityRepository.findByName(originCityName));
    }

    private void setDestinationAirport(Tour tour, String destinationAirportName) {
        tour.setDestinationAirport(airportRepository.findByName(destinationAirportName));
    }

    private void setOriginAirport(Tour tour, String originAirportName) {
        tour.setOriginAirport(airportRepository.findByName(originAirportName));
    }

    private void setHotel(Tour tour, String hotelName) {
        tour.setDestinationHotel(hotelRepository.findByName(hotelName));
    }


    private static Integer subtractDates(String stringStartDate, String stringEndDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse(stringStartDate);
        Date endDate = dateFormat.parse(stringEndDate);
        double doubleResultOfSubtract = ((endDate.getTime() - startDate.getTime()) / 86400000.0);
        return (int) doubleResultOfSubtract;
    }


    @Override
    public void save(Tour tour) {
        tourRepository.save(tour);
    }

    @Override
    public void save(Tour tour, String destinationCityName, String originCityName,
                     String originAirportName, String destinationAirportName,
                     String hotelName) {
        this.calculateAndSetDuration(tour);
        this.setDestinationCity(tour, destinationCityName);
        this.setOriginCity(tour, originCityName);
        this.setOriginAirport(tour, originAirportName);
        this.setDestinationAirport(tour, destinationAirportName);
        this.setHotel(tour, hotelName);
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
    public List<Tour> get3PromotedTours() {

        List<Tour> allTours = tourRepository.findAll();

        List<Tour> promotedTours = new ArrayList<>();
        int counter = 0;

        for (Tour tour : allTours) {
            if (tour.getPromotion() && counter < 3) {
                promotedTours.add(tour);
                counter++;
            }
        }
        return promotedTours;
    }

    @Override
    public List<Tour> get3ComingTours() {

        List<Tour> allToursSortedByClosest = tourRepository.findAll().stream()
                .sorted((Comparator.comparing(Tour::getStartDate)))
                .collect(Collectors.toList());

        List<Tour> commingTours = new ArrayList<>();
        int counter = 0;

        for (Tour tour : allToursSortedByClosest) {
            if (counter < 3) {
                commingTours.add(tour);
                counter++;
            }
        }
        return commingTours;
    }

    @Override
    public void updatePromById(Integer id, Boolean newProm) {
        tourRepository.updatePromotionById(id.longValue(), newProm);
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

    public String getActiveFilter(String searchField, String filter) {
        switch (filter) {
            case "destinationCity":
                return "Cel wycieczki: " + searchField;
            case "originCity":
                return "Miasto wyjazdu: " + searchField;
            case "durationTime":
                return "Czas trwania co najmniej: " + searchField + " dni";
        }
        return "";
    }

    @Override
    public List<Tour> sortTours(String sort, List<Tour> filteredTours) {

        switch (sort) {
            case "adultPrice":
                return filteredTours.stream()
                        .sorted(Comparator.comparing(Tour::getAdultPrice))
                        .collect(Collectors.toList());
            case "minorPrice":
                return filteredTours.stream()
                        .sorted(Comparator.comparing(Tour::getMinorPrice))
                        .collect(Collectors.toList());
            case "durationTime":
                return filteredTours.stream()
                        .sorted(Comparator.comparing(Tour::getDurationTime))
                        .collect(Collectors.toList());
        }
        return Collections.emptyList();

    }

    @Override
    public void update(Integer id, TourSketch newTourSketch) {
        Tour oldTour = tourRepository.getById(id.longValue());
        try {
            Tour newTour = Tour.builder()
                    .id(id.longValue())
                    .destinationCity(cityRepository.findByName(newTourSketch.getDestinationCityName()))
                    .destinationAirport(airportRepository.findByName(newTourSketch.getDestinationAirportName()))
                    .destinationHotel(hotelRepository.findByName(newTourSketch.getDestinationHotelName()))
                    .originCity(cityRepository.findByName(newTourSketch.getOriginCityName()))
                    .originAirport(airportRepository.findByName(newTourSketch.getOriginAirportName()))
                    .startDate(LocalDate.parse(newTourSketch.getStartDate()))
                    .endDate(LocalDate.parse(newTourSketch.getEndDate()))
                    .durationTime(subtractDates(newTourSketch.getStartDate(), newTourSketch.getEndDate()))
                    .adultPrice(new BigDecimal(newTourSketch.getAdultPrice()))
                    .minorPrice(new BigDecimal(newTourSketch.getMinorPrice()))
                    .adultSeats(Integer.parseInt(newTourSketch.getAdultSeats()))
                    .minorSeats(Integer.parseInt(newTourSketch.getMinorSeats()))
                    .promotion(oldTour.getPromotion())
                    .build();
            tourRepository.save(newTour);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
