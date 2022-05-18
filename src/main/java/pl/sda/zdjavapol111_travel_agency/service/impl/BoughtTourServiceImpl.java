package pl.sda.zdjavapol111_travel_agency.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol111_travel_agency.model.BoughtTour;
import pl.sda.zdjavapol111_travel_agency.repository.BoughtTourRepository;
import pl.sda.zdjavapol111_travel_agency.service.BoughtTourService;

import java.util.List;

@Service
public class BoughtTourServiceImpl implements BoughtTourService {

    @Autowired
    BoughtTourRepository boughtTourRepository;

    @Override
    public List<BoughtTour> findAll() {
        return boughtTourRepository.findAll();
    }
}
