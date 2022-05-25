package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
//import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
public class BoughtTour {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal price;

    private Integer adultAmount;

    private Integer childAmount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tour tour;

    @Builder
    private BoughtTour(Integer id, BigDecimal price, Integer adultAmount, Integer childAmount, Customer customer, Tour tour) {
        this.id = id;
        this.price = price;
        this.adultAmount = adultAmount;
        this.childAmount = childAmount;
        this.customer = customer;
        this.tour = tour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoughtTour that = (BoughtTour) o;
        return Objects.equals(id, that.id) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }

    @Override
    public String toString() {
        return "BoughtTour{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
