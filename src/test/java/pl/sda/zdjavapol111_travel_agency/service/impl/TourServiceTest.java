package pl.sda.zdjavapol111_travel_agency.service.impl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import pl.sda.zdjavapol111_travel_agency.model.Airport;
import pl.sda.zdjavapol111_travel_agency.model.City;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.model.TourSketch;
import pl.sda.zdjavapol111_travel_agency.repository.AirportRepository;
import pl.sda.zdjavapol111_travel_agency.repository.TourRepository;
import pl.sda.zdjavapol111_travel_agency.service.TourService;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
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



    @BeforeEach
    public void setUp() {
        tourRepository.deleteAll();
    }

    @PostConstruct
    public void init() {
        transactionTemplate = new TransactionTemplate(transactionManager);
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
        //TODO
    }

}



