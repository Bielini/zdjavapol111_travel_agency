package pl.sda.zdjavapol111_travel_agency.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.repository.TourRepository;
import pl.sda.zdjavapol111_travel_agency.service.TourService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;

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
}
