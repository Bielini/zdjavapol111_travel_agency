package pl.sda.zdjavapol111_travel_agency.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.zdjavapol111_travel_agency.model.BoughtTour;
import pl.sda.zdjavapol111_travel_agency.model.Customer;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.repository.BoughtTourRepository;
import pl.sda.zdjavapol111_travel_agency.repository.TourRepository;

import javax.transaction.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BoughtTourServiceTest {

    @Autowired
    BoughtTourRepository boughtTourRepository;

    @Autowired
    BoughtTourService boughtTourService;

    @Autowired
    TourRepository tourRepository;

    @Autowired
    TourService tourService;

//    @BeforeEach
//    public void setUp(){
//       tourRepository.deleteAll();
//    }

    @Transactional
    @Test
    void getById() {
//        //given
//        Tour pierwsza = Tour.builder()
//                .id(1l)
//                .build();
//        tourRepository.save(pierwsza);
//        //when
//        Tour getById = tourService.getById(1);
//        //then
//        Assertions.assertEquals(1,1);


    }

    @Test
    void save() {
    }
}