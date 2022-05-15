package pl.sda.zdjavapol111_travel_agency.service;

import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.repository.TourRepository;

public interface TourService {

    void calculateDuration(Tour tour);
}
