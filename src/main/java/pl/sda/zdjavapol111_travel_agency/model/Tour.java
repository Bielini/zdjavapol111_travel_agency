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
    private Airport destinationAirport; // to dodałam

    @OneToOne(fetch = FetchType.LAZY)
    private Hotel destinationHotel; // to dodałam

    @ManyToOne(fetch = FetchType.EAGER)
    private City originCity;

    @OneToOne(fetch = FetchType.LAZY)
    private Airport originAirport; // to dodałam

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate; // to dodałam

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate; // to dodałam

    private Integer durationTime;

    private BigDecimal adultPrice;

    private BigDecimal minorPrice;

    private Boolean promotion;

    private Integer adultSeats;

    private Integer minorSeats;


}
