package pl.sda.zdjavapol111_travel_agency.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol111_travel_agency.model.City;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.repository.AirportRepository;
import pl.sda.zdjavapol111_travel_agency.repository.CityRepository;
import pl.sda.zdjavapol111_travel_agency.repository.HotelRepository;
import pl.sda.zdjavapol111_travel_agency.repository.TourRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Slf4j
@Primary
@Service
public class TourPurchaseService implements pl.sda.zdjavapol111_travel_agency.service.TourPurchaseService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Tour getById(Long id) {
        return tourRepository.getById(id);
    }

    @Override
    public String getCityNameById(Integer id){
        return cityRepository.getById(id).getName();
    }

    @Override
    public String getAirportNameById(Integer id) {
        return airportRepository.getById(id).getName();
    }

    @Override
    public String getHotelNameById(Integer id) {
        return hotelRepository.getById(id).getName();
    }

    @Override
    public LocalDate getDateFormById(Long id) {
        return tourRepository.getById(id).getDateFrom();
    }

    @Override
    public LocalDate getDateToById(Long id) {
        return tourRepository.getById(id).getDateTo();
    }

    @Override
    public Integer getAdultSeatsById(Long id) {
        return tourRepository.getById(id).getAdultSeats();
    }

    @Override
    public Integer getMinorSeatsById(Long id) {
        return tourRepository.getById(id).getMinorSeats();
    }

    @Override
    public BigDecimal getAdultPriceById(Long id) {
        return tourRepository.getById(id).getAdultPrice();
    }

    @Override
    public BigDecimal getMinorPriceById(Long id) {
        return tourRepository.getById(id).getMinorPrice();
    }

    @Override
    public BigDecimal getEndPriceById(Long id) {
        return null;
    }


}
