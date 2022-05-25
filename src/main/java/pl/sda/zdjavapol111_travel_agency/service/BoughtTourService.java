package pl.sda.zdjavapol111_travel_agency.service;

import pl.sda.zdjavapol111_travel_agency.model.BoughtTour;
import pl.sda.zdjavapol111_travel_agency.model.Customer;
import pl.sda.zdjavapol111_travel_agency.model.Tour;

import javax.persistence.criteria.CriteriaBuilder;

public interface BoughtTourService {

    Tour getById(Long id);

    void countPrice(BoughtTour boughtTour);

    void save(BoughtTour boughtTour, Customer customer, Tour tour);




}
