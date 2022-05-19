package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TourSketch {



    private String destinationCityName;

    private String destinationAirportName;

    private String destinationHotelName;

    private String originCityName;

    private String originAirportName;

    private String startDate;

    private String endDate;

    private String adultPrice;

    private String minorPrice;

    private String adultSeats;

    private String minorSeats;

    private String promotion;
}
