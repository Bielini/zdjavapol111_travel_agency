package pl.sda.zdjavapol111_travel_agency.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.zdjavapol111_travel_agency.model.City;
import pl.sda.zdjavapol111_travel_agency.model.Continent;
import pl.sda.zdjavapol111_travel_agency.model.Country;
import pl.sda.zdjavapol111_travel_agency.repository.AirportRepository;
import pl.sda.zdjavapol111_travel_agency.repository.CityRepository;
import pl.sda.zdjavapol111_travel_agency.repository.ContinentRepository;
import pl.sda.zdjavapol111_travel_agency.repository.CountryRepository;
import pl.sda.zdjavapol111_travel_agency.service.CityService;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
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
        Continent europe = Continent.builder()
                .name("Europa")
                .build();
        continentRepository.save(europe);

        Country poland = Country.builder()
                .name("Polska")
                .continent(continentRepository.findByName("Europa"))
                .build();
        countryRepository.save(poland);

        cityRepository.save(City.builder()
                .name("Warszawa")
                .country(countryRepository.findByName("Polska"))
                .build());

        //when
        List<City> all = cityService.findAll();

        //then
        Assertions.assertEquals(1, all.size());
        Assertions.assertEquals("Warszawa", all.stream().findAny().get().getName());
    }
}