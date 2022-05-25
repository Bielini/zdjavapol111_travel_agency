package pl.sda.zdjavapol111_travel_agency.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol111_travel_agency.model.BoughtTour;
import pl.sda.zdjavapol111_travel_agency.model.Customer;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.repository.*;
import pl.sda.zdjavapol111_travel_agency.service.BoughtTourService;

import java.math.BigDecimal;
import java.util.List;


@Slf4j
@Primary
@Service
public class BoughtTourServiceImpl implements BoughtTourService {

    @Autowired
    private TourRepository tourRepository;


    @Autowired
    private BoughtTourRepository boughtTourRepository;

    @Autowired
    private  CustomerRepository customerRepository;


    @Override
    public Tour getById(Long id) {
        return tourRepository.getById(id);
    }


    @Override
    public void countPrice(BoughtTour boughtTour) {
        boughtTour.setPrice(boughtTour.getTour().getMinorPrice().multiply(BigDecimal.valueOf(boughtTour.getChildAmount())).add(boughtTour.getTour().getAdultPrice().multiply(BigDecimal.valueOf(boughtTour.getAdultAmount()))));
    }

    @Override
    public void save(BoughtTour boughtTour, Customer customer, Tour tour) {
            boughtTour.setCustomer(customer);
            boughtTour.setTour(tour);
            countPrice(boughtTour);
            boughtTourRepository.save(boughtTour);
    }

    public List<BoughtTour> findAll() {
        return boughtTourRepository.findAll();
    }


}
