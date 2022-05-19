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

@Slf4j
@Primary
@Service
public class BoughtTourServiceImpl implements BoughtTourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private BoughtTourRepository boughtTourRepository;

    public void setAdultAmount(BoughtTour boughtTour, Integer adultAmount){
        boughtTour.setAdultAmount(adultAmount);
    }

    public void setChildAmount(BoughtTour boughtTour, Integer childAmount){
        boughtTour.setChildAmount(childAmount);
    }

    public void setPrice(BoughtTour boughtTour, BigDecimal price){
        boughtTour.setPrice(price);
    }

//    public void setCustomer(BoughtTour boughtTour, Customer customer){
//        boughtTour.setCustomer(customer);
//    }

//    public void setTour(BoughtTour boughtTour, Tour tour){
//        boughtTour.setTour(tour);
//    }

    @Override
    public Tour getById(Long id) {
        return tourRepository.getById(id);
    }

    @Override
    public void save(BoughtTour boughtTour) {
        boughtTourRepository.save(boughtTour);
    }



//    @Override
//    public String getCityNameById(Integer id){
//        return cityRepository.getById(id).getName();
//    }
//
//    @Override
//    public String getAirportNameById(Integer id) {
//        return airportRepository.getById(id).getName();
//    }
//
//    @Override
//    public String getHotelNameById(Integer id) {
//        return hotelRepository.getById(id).getName();
//    }
//
//    @Override
//    public LocalDate getStartDateById(Long id) {
//        return tourRepository.getById(id).getStartDate();
//    }
//
//    @Override
//    public LocalDate getEndDateById(Long id) {
//        return tourRepository.getById(id).getEndDate();
//    }
//
//    @Override
//    public Integer getAdultSeatsById(Long id) {
//        return tourRepository.getById(id).getAdultSeats();
//    }
//
//    @Override
//    public Integer getMinorSeatsById(Long id) {
//        return tourRepository.getById(id).getMinorSeats();
//    }
//
//    @Override
//    public BigDecimal getAdultPriceById(Long id) {
//        return tourRepository.getById(id).getAdultPrice();
//    }
//
//    @Override
//    public BigDecimal getMinorPriceById(Long id) {
//        return tourRepository.getById(id).getMinorPrice();
//    }
//
//    @Override
//    public BigDecimal getEndPriceById(Long id) {
//        throw  new UnsupportedOperationException();
//    }


}
