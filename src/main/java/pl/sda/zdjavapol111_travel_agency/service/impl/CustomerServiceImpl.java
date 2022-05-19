package pl.sda.zdjavapol111_travel_agency.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol111_travel_agency.model.BoughtTour;
import pl.sda.zdjavapol111_travel_agency.model.Customer;
import pl.sda.zdjavapol111_travel_agency.repository.BoughtTourRepository;
import pl.sda.zdjavapol111_travel_agency.repository.CustomerRepository;
import pl.sda.zdjavapol111_travel_agency.service.CustomerService;


import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BoughtTourRepository boughtTourRepository;


    public void setCustomerName(Customer customer, String name){
        customer.setName(name);
    }

    public void setCustomerSurname(Customer customer, String surname){
        customer.setSurname(surname);
    }

    public void setCustomerEmail(Customer customer, String email){
        customer.setEmail(email);
    }

    public void addBoughtTour(Customer customer, List boughtTours){
//        BoughtTour id = customer.getBoughtTours().get(boughtTours.lastIndexOf(customer.getBoughtTours())+1);
//        customer.getBoughtTours().add(id);
        boughtTours.add(new BoughtTour());
    }



    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }
}

