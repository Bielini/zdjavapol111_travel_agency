package pl.sda.zdjavapol111_travel_agency.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.repository.TourRepository;
import javax.transaction.Transactional;
import java.util.List;

public interface TourService {

    void save(Tour tour);

    List<Tour> getAllTours();

    void deleteById(Integer id);

    Tour getById(Integer id);

    List<Tour> get2PromotedTours();

    List<Tour> getToursByDurationTime(Integer duration);

    List<Tour> getToursByDestCity(String name);

    List<Tour> getToursByOriginCity(String name);

    List<Tour> filterTours(String searchField, String filter);

    void calculateDuration(Tour tour);
}
