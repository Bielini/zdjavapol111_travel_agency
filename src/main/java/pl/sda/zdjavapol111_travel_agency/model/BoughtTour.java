package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
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

//    @Min(value = 1, message = "Ilość musi być większa od 1")
    private Integer adultAmount;

//    @Min(value = 0, message = "Ilość musi być większa od 0")
    private Integer childAmount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tour tour;

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
