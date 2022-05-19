package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
public class BoughtTour {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal price;

    @Min(value = 1, message = "Ilość musi być większa od 1")
    private Integer adultAmount;

    @Min(value = 0, message = "Ilość musi być większa od 0")
    private Integer childAmount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tour tour;




}
