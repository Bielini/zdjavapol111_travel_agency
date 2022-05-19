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
        tourRepository.updatePromotionById(id.longValue(), newProm);
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
    public void checkAndUpdate(Integer id, TourSketch newTourSketch) {
        Tour oldTour = tourRepository.getById(id.longValue());

        if (!oldTour.getDestinationCity().getName().equals(newTourSketch.getDestinationCityName())) {
            updateToursDestinationCity(oldTour.getId(), newTourSketch.getDestinationCityName());
        }
        if (!oldTour.getDestinationAirport().getName().equals(newTourSketch.getDestinationAirportName())) {
            updateToursDestinationAirport(oldTour.getId(), newTourSketch.getDestinationAirportName());
        }
        if (!oldTour.getDestinationHotel().getName().equals(newTourSketch.getDestinationHotelName())) {
            updateToursDestinationHotel(oldTour.getId(), newTourSketch.getDestinationHotelName());
        }
        if (!oldTour.getOriginCity().getName().equals(newTourSketch.getOriginCityName())) {
            updateToursOriginCity(oldTour.getId(), newTourSketch.getOriginCityName());
        }
        if (!oldTour.getOriginAirport().getName().equals(newTourSketch.getOriginAirportName())) {
            updateToursOriginAirport(oldTour.getId(), newTourSketch.getOriginAirportName());
        }
        if (!oldTour.getStartDate().toString().equals(newTourSketch.getStartDate())) {
            updateToursStartDate(oldTour.getId(), newTourSketch.getStartDate());
        }
        if (!oldTour.getEndDate().toString().equals(newTourSketch.getEndDate())) {
            updateToursEndDate(oldTour.getId(), newTourSketch.getEndDate());
        }

        try {
            if (!getOldTourDuration(oldTour).equals(subtractDates(newTourSketch.getStartDate(), newTourSketch.getEndDate()))) {
                updateToursDuration(oldTour.getId(), newTourSketch.getStartDate(), newTourSketch.getEndDate());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!oldTour.getAdultPrice().toString().equals(newTourSketch.getAdultPrice())) {
            updateToursAdultPrice(oldTour.getId(), newTourSketch.getAdultPrice());
        }
        if (!oldTour.getMinorPrice().toString().equals(newTourSketch.getMinorPrice())) {
            updateToursMinorPrice(oldTour.getId(), newTourSketch.getMinorPrice());
        }
        if (!oldTour.getAdultSeats().toString().equals(newTourSketch.getAdultSeats())) {
            updateToursAdultSeats(oldTour.getId(), newTourSketch.getAdultSeats());
        }
        if (!oldTour.getMinorSeats().toString().equals(newTourSketch.getMinorSeats())) {
            updateToursMinorSeats(oldTour.getId(), newTourSketch.getMinorSeats());
        }

        if (!oldTour.getPromotion().toString().equals(newTourSketch.getPromotion())) {
            updatePromById(oldTour.getId().intValue(), Boolean.getBoolean(newTourSketch.getPromotion()));
        }


    }

    private Integer getOldTourDuration(Tour oldTour) throws ParseException {
        return subtractDates(oldTour.getStartDate().toString(), oldTour.getEndDate().toString());
    }

    private void updateToursDestinationCity(Long id, String destinationCityName) {
        tourRepository.updateDestinationCityById(id, cityRepository.findByName(destinationCityName));
    }

    private void updateToursDestinationAirport(Long id, String destinationAirportName) {
        tourRepository.updateDestinationAirportById(id, airportRepository.findByName(destinationAirportName));
    }

    private void updateToursDestinationHotel(Long id, String destinationHotelName) {
        tourRepository.updateDestinationHotelById(id, hotelRepository.findByName(destinationHotelName));
    }

    private void updateToursOriginCity(Long id, String originCityName) {
        tourRepository.updateOriginCityById(id, cityRepository.findByName(originCityName));
    }

    private void updateToursOriginAirport(Long id, String originAirportName) {
        tourRepository.updateOriginAirportById(id, airportRepository.findByName(originAirportName));
    }

    private void updateToursStartDate(Long id, String startDate) {
        tourRepository.updateStartDateById(id, LocalDate.parse(startDate));
    }

    private void updateToursEndDate(Long id, String endDate) {
        tourRepository.updateEndDateById(id, LocalDate.parse(endDate));
    }

    private void updateToursDuration(Long id, String startDate, String endDate) {
        try {
            tourRepository.updateDurationById(id, subtractDates(startDate, endDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void updateToursAdultPrice(Long id, String adultPrice) {
        tourRepository.updateAdultPriceById(id, new BigDecimal(adultPrice));
    }

    private void updateToursMinorPrice(Long id, String minorPrice) {
        tourRepository.updateMinorPriceById(id, new BigDecimal(minorPrice));
    }

    private void updateToursAdultSeats(Long id, String adultSeats) {
        tourRepository.updateAdultSeatsById(id, Integer.parseInt(adultSeats));
    }

    private void updateToursMinorSeats(Long id, String minorSeats) {
        tourRepository.updateMinorSeatsById(id, Integer.parseInt(minorSeats));
    }

}
