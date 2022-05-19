package pl.sda.zdjavapol111_travel_agency.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private City destinationCity;

    @OneToOne(fetch = FetchType.LAZY)
    private Airport destinationAirport;

    @OneToOne(fetch = FetchType.LAZY)
    private Hotel destinationHotel;

    @ManyToOne(fetch = FetchType.EAGER)
    private City originCity;

    @OneToOne(fetch = FetchType.LAZY)
    private Airport originAirport;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    private Integer durationTime;

    private BigDecimal adultPrice;

    private BigDecimal minorPrice;

    private Boolean promotion;

    private Integer adultSeats;

    private Integer minorSeats;


    @Builder
    public Tour(Long id, City destinationCity, Airport destinationAirport, Hotel destinationHotel, City originCity, Airport originAirport, LocalDate startDate, LocalDate endDate, Integer durationTime, BigDecimal adultPrice, BigDecimal minorPrice, Boolean promotion, Integer adultSeats, Integer minorSeats) {
        this.id = id;
        this.destinationCity = destinationCity;
        this.destinationAirport = destinationAirport;
        this.destinationHotel = destinationHotel;
        this.originCity = originCity;
        this.originAirport = originAirport;
        this.startDate = startDate;
        this.endDate = endDate;
        this.durationTime = durationTime;
        this.adultPrice = adultPrice;
        this.minorPrice = minorPrice;
        this.promotion = promotion;
        this.adultSeats = adultSeats;
        this.minorSeats = minorSeats;
    }

    public Tour() {
    }
}
