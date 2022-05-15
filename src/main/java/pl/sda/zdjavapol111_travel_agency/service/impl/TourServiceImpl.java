package pl.sda.zdjavapol111_travel_agency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.repository.TourRepository;
import pl.sda.zdjavapol111_travel_agency.service.TourService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    TourRepository tourRepository;


    @Override
    public void calculateDuration(Tour tour) {
        try {
            tour.setDurationTime(subtractDates(tour.getStartDate(), tour.getEndDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static Integer subtractDates(String stringStartDate, String stringEndDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse(stringStartDate);
        Date endDate = dateFormat.parse(stringEndDate);
        Double doubleResultOfSubtract = ((endDate.getTime() - startDate.getTime())/86400000.0);
        return doubleResultOfSubtract.intValue();
    }
}
