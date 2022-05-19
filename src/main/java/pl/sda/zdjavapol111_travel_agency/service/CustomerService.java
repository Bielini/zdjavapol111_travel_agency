package pl.sda.zdjavapol111_travel_agency.service;

import pl.sda.zdjavapol111_travel_agency.model.Airport;
import pl.sda.zdjavapol111_travel_agency.model.BoughtTour;
import pl.sda.zdjavapol111_travel_agency.model.Customer;
import pl.sda.zdjavapol111_travel_agency.model.Tour;

import java.util.List;

public interface CustomerService {

    Customer getById(Integer id);

    List<Customer> findAll();

    void save (Customer customer);
}
