package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class BoughtTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tour tour;
}
