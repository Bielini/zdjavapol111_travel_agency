package pl.sda.zdjavapol111_travel_agency.model;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data

public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private City destinationCity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Airport destinationAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel destinationHotel;

    @ManyToOne(fetch = FetchType.EAGER)
    private City originCity;

    @ManyToOne(fetch = FetchType.LAZY)
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

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    List<BoughtTour> boughtTours;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(id, tour.id) && Objects.equals(destinationCity, tour.destinationCity) && Objects.equals(destinationAirport, tour.destinationAirport) && Objects.equals(destinationHotel, tour.destinationHotel) && Objects.equals(originCity, tour.originCity) && Objects.equals(originAirport, tour.originAirport) && Objects.equals(startDate, tour.startDate) && Objects.equals(endDate, tour.endDate) && Objects.equals(durationTime, tour.durationTime) && Objects.equals(adultPrice, tour.adultPrice) && Objects.equals(minorPrice, tour.minorPrice) && Objects.equals(promotion, tour.promotion) && Objects.equals(adultSeats, tour.adultSeats) && Objects.equals(minorSeats, tour.minorSeats);
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(id, destinationCity, destinationAirport, destinationHotel, originCity, originAirport, startDate, endDate, durationTime, adultPrice, minorPrice, promotion, adultSeats, minorSeats);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "destinationCity=" + destinationCity +
                ", destinationAirport=" + destinationAirport +
                ", destinationHotel=" + destinationHotel +
                ", originCity=" + originCity +
                ", originAirport=" + originAirport +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", durationTime=" + durationTime +
                ", adultPrice=" + adultPrice +
                ", minorPrice=" + minorPrice +
                ", promotion=" + promotion +
                ", adultSeats=" + adultSeats +
                ", minorSeats=" + minorSeats +
                '}';
    }
}
