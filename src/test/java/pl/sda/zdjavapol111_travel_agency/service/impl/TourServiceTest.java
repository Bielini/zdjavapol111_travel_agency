package pl.sda.zdjavapol111_travel_agency.service.impl;


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import pl.sda.zdjavapol111_travel_agency.model.*;
import pl.sda.zdjavapol111_travel_agency.repository.*;
import pl.sda.zdjavapol111_travel_agency.service.TourService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;


@SpringBootTest
public class TourServiceTest {

    @Autowired
    private PlatformTransactionManager transactionManager;
    private TransactionTemplate transactionTemplate;


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

    @PostConstruct
    public void init() {
        transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @Test
    public void shouldSaveTourToRepository() {
        //given
        Tour tour = Tour.builder()
                .startDate(LocalDate.of(2022, 7, 25))
                .endDate(LocalDate.of(2022, 7, 30))
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
        String hotelName = "Acropolis Ami Boutique Hotel";
        //when
        tourService.save(tour, destinationCityName, originCityName, originAirportName, destinationAirportName, hotelName);
        List<Tour> tours = tourRepository.findAll();
        //then
        Assert.assertEquals(tours.size(), 1);
        Assert.assertEquals(tours.get(0).getDestinationCity().getName(), destinationCityName);
        Assert.assertEquals(tours.get(0).getOriginCity().getName(), originCityName);
        Assert.assertEquals(tours.get(0).getDestinationAirport().getName(), destinationAirportName);
        Assert.assertEquals(tours.get(0).getOriginAirport().getName(), originAirportName);
        Assert.assertEquals(tours.get(0).getDestinationHotel().getName(), hotelName);
        Assert.assertEquals(tours.get(0).getDurationTime(), Integer.valueOf(5));
    }

    @Test
    public void shouldSaveTour() {
        //G
        Tour tour = Tour.builder()
                .id(1L)
                .durationTime(14)
                .build();

        //W
        tourService.save(tour);

        //G
        Assertions.assertEquals(1, tourRepository.findAll().size());
        Assertions.assertEquals(14, tourRepository.findAll().stream().findAny().get().getDurationTime());

    }

    @Test
    public void shouldUpdatePromotion() {
        //given

        Tour tour = transactionTemplate.execute(c -> tourRepository.save(Tour.builder().promotion(false).build()));

        //when
        transactionTemplate.execute(t -> {
            tourService.updatePromById(tour.getId().intValue(), true);
            return null;
        });

        //then
        Assertions.assertEquals(true, tourRepository.findAll().stream()
                .findAny()
                .get()
                .getPromotion());
    }

    @Test
    public void shouldReturn3PromotedTours() {
        //G

        Tour tourNegative = Tour.builder()
                .id(1L)
                .promotion(false)
                .build();
        tourRepository.save(tourNegative);

        for (int i = 1; i < 5; i++) {
            Tour tour = Tour.builder()
                    .id((long) (i + 1))
                    .promotion(true)
                    .build();
            tourRepository.save(tour);
        }

        //W
        List<Tour> promotedTours = tourService.get3PromotedTours();

        //T
        Assertions.assertEquals(3, promotedTours.size());

        for (Tour promotedTour : promotedTours) {
            Assertions.assertTrue(promotedTour.getPromotion());
        }
    }

    @Test
    public void shouldReturnActiveFilter() {
        String positiveFilter = "destinationCity";
        String searchField = "Warszawa";

        String activeFilter = tourService.getActiveFilter(searchField, positiveFilter);

        Assertions.assertEquals("Cel wycieczki: " + searchField, activeFilter);
    }

    @Test
    public void shouldReturnEmptyString() {
        String negativeFilter = "ebeebe";
        String searchField = "Warszawa";

        String activeFilter = tourService.getActiveFilter(searchField, negativeFilter);

        Assertions.assertEquals("", activeFilter);
    }

    @Test
    public void shouldReturn3ClosestTours() {

        Tour tour = Tour.builder()
                .id(1L)
                .startDate(LocalDate.parse("2022-03-22"))
                .build();
        tourRepository.save(tour);

        tour = Tour.builder()
                .id(2L)
                .startDate(LocalDate.parse("2022-03-17"))
                .build();
        tourRepository.save(tour);

        Tour closestTour = Tour.builder()
                .id(3L)
                .startDate(LocalDate.parse("2022-02-01"))
                .build();
        tourRepository.save(closestTour);

        tour = Tour.builder()
                .id(4L)
                .startDate(LocalDate.parse("2022-02-22"))
                .build();
        tourRepository.save(tour);


        List<Tour> comingTours = tourService.get3ComingTours();

        Assertions.assertEquals(3, comingTours.size());
        Assertions.assertEquals(closestTour.getStartDate(), comingTours.get(0).getStartDate());
    }


    @Test
    public void shouldUpdateTour() {
       //TODO napiszę
    }

}



