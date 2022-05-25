package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Builder;
import lombok.Data;

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

    public TourSketch() {
    }

    @Builder
    public TourSketch(String destinationCityName, String destinationAirportName, String destinationHotelName, String originCityName, String originAirportName, String startDate, String endDate, String adultPrice, String minorPrice, String adultSeats, String minorSeats, String promotion) {
        this.destinationCityName = destinationCityName;
        this.destinationAirportName = destinationAirportName;
        this.destinationHotelName = destinationHotelName;
        this.originCityName = originCityName;
        this.originAirportName = originAirportName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.adultPrice = adultPrice;
        this.minorPrice = minorPrice;
        this.adultSeats = adultSeats;
        this.minorSeats = minorSeats;
        this.promotion = promotion;
    }
}
