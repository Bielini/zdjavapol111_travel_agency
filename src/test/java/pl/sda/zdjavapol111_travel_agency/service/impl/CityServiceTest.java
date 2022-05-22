package pl.sda.zdjavapol111_travel_agency.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.zdjavapol111_travel_agency.model.City;
import pl.sda.zdjavapol111_travel_agency.model.Continent;
import pl.sda.zdjavapol111_travel_agency.model.Country;
import pl.sda.zdjavapol111_travel_agency.repository.CityRepository;
import pl.sda.zdjavapol111_travel_agency.repository.ContinentRepository;
import pl.sda.zdjavapol111_travel_agency.repository.CountryRepository;
import pl.sda.zdjavapol111_travel_agency.service.CityService;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
class CityServiceTest {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CityService cityService;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ContinentRepository continentRepository;

    @BeforeEach
    public void setUp() {
        cityRepository.deleteAll();
        countryRepository.deleteAll();
        continentRepository.deleteAll();
    }

    @Test
    public void testXxx() {
        //given
        cityRepository.save(City.builder()
                .name("Warszawa")
                .country(countryRepository.save(Country.builder()
                        .name("Polska")
                        .continents(continentRepository.save(Continent.builder()
                                .name("Europa")
                                .build()))
                        .build()))
                .build());

        //when
        List<City> all = cityRepository.findAll();

        //then
        Assertions.assertEquals(1, all.size());
        Assertions.assertEquals("Warszawa", all.stream().findAny().get().getName());
    }
}