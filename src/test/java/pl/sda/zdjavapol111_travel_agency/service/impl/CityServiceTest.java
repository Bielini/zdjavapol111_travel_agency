package pl.sda.zdjavapol111_travel_agency.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.zdjavapol111_travel_agency.model.City;
import pl.sda.zdjavapol111_travel_agency.repository.CityRepository;
import pl.sda.zdjavapol111_travel_agency.repository.CountryRepository;
import pl.sda.zdjavapol111_travel_agency.service.CityService;

@DataJpaTest
class CityServiceTest {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CityService cityService;

    @Autowired
    CountryRepository countryRepository;

    @BeforeEach
    public void setUp() {
        cityRepository.deleteAll();
    }

    @Test
    public void testXxx() {
   //     cityRepository.save(City.builder().name("Warszawa")..build())
    }
}