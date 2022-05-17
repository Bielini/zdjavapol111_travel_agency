package pl.sda.zdjavapol111_travel_agency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol111_travel_agency.model.Hotel;
import pl.sda.zdjavapol111_travel_agency.repository.HotelRepository;
import pl.sda.zdjavapol111_travel_agency.service.HotelService;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;
    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }
}
