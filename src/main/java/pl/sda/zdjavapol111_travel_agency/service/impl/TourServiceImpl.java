package pl.sda.zdjavapol111_travel_agency.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
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


    @Override
    public void calculateDuration(Tour tour) {
        try {
            tour.setDurationTime(subtractDates(tour.getStartDate(), tour.getEndDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static Integer subtractDates(String stringStartDate, String stringEndDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse(stringStartDate);
        Date endDate = dateFormat.parse(stringEndDate);
        Double doubleResultOfSubtract = ((endDate.getTime() - startDate.getTime())/86400000.0);
        return doubleResultOfSubtract.intValue();
    }


    @Override
    public void save(Tour tour) {
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
                try{
                    return tourRepository.findAllToursByDurationTime(Integer.parseInt(searchField));
                }catch (IllegalArgumentException e){
                    log.error("Thrown:"+e.getMessage());
                }
        }
        return Collections.emptyList();
    }

}
