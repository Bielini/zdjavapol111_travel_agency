package pl.sda.zdjavapol111_travel_agency.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.zdjavapol111_travel_agency.model.*;
import pl.sda.zdjavapol111_travel_agency.repository.*;
import pl.sda.zdjavapol111_travel_agency.service.TourService;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TourServiceTest {

    @Autowired
    TourService tourService;

    @Autowired
    TourRepository tourRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ContinentRepository continentRepository;

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    HotelRepository hotelRepository;

    @BeforeEach
    void setUp() {
        tourRepository.deleteAll();
        cityRepository.deleteAll();
        airportRepository.deleteAll();
        hotelRepository.deleteAll();
        countryRepository.deleteAll();
        continentRepository.deleteAll();
    }

    @Test
    public void shouldSaveTourToRepository() {
        //given
        Tour tour = Tour.builder()
                .startDate(LocalDate.of(2022, 7, 25))
                .endDate(LocalDate.of(2022,7,30))
                .build();

        Continent europe = Continent.builder()
                .name("Europa")
                .build();
        continentRepository.save(europe);

        Country greece = Country.builder()
                .name("Grecja")
                .continent(continentRepository.findByName("Europa"))
                .build();
        countryRepository.save(greece);

        Country poland = Country.builder()
                .name("Polska")
                .continent(continentRepository.findByName("Europa"))
                .build();
        countryRepository.save(poland);

        City athens = City.builder()
                .name("Ateny")
                .country(countryRepository.findByName("Grecja"))
                .build();
        cityRepository.save(athens);

        cityRepository.save(City.builder()
                .name("Warszawa")
                .country(countryRepository.findByName("Polska"))
                .build());

        airportRepository.save(Airport.builder()
                .city(cityRepository.findByName("Ateny"))
                .name("Athens International Airport")
                .build());

        airportRepository.save(Airport.builder()
                .name("Lotnisko Chopina w Warszawie")
                .city(cityRepository.findByName("Warszawa"))
                .build());

        hotelRepository.save(Hotel.builder()
                .city(cityRepository.findByName("Ateny"))
                .name("Acropolis Ami Boutique Hotel")
                .build());

        String destinationCityName = "Ateny";
        String originCityName = "Warszawa";
        String originAirportName = "Lotnisko Chopina w Warszawie";
        String destinationAirportName = "Athens International Airport";
        String hotelName= "Acropolis Ami Boutique Hotel";
        //when
        tourService.save(tour, destinationCityName, originCityName, originAirportName, destinationAirportName, hotelName);
        //then
        Assert.assertEquals(tourRepository.findAll().size(), 1);
        Assert.assertEquals(tourRepository.findAll().get(0).getDestinationCity().getName(), destinationCityName);
        Assert.assertEquals(tourRepository.findAll().get(0).getOriginCity().getName(), originCityName);
        Assert.assertEquals(tourRepository.findAll().get(0).getDestinationAirport().getName(), destinationAirportName);
        Assert.assertEquals(tourRepository.findAll().get(0).getOriginAirport().getName(), originAirportName);
        Assert.assertEquals(tourRepository.findAll().get(0).getDestinationHotel().getName(), hotelName);
        //TODO przetestować calculateAndSetDuration();
    }
}