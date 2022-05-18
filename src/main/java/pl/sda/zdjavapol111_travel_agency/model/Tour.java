package pl.sda.zdjavapol111_travel_agency.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
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


}
