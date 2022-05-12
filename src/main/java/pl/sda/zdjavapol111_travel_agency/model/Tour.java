package pl.sda.zdjavapol111_travel_agency.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data

public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private City destinationCity;

    @ManyToOne(fetch = FetchType.EAGER)
    private City originCity;

    private Date startDate;

    private Integer durationTime;

    private BigDecimal adultPrice;

    private BigDecimal minorPrice;

    private Boolean promotion;

    private Integer adultSeats;

    private Integer minorSeats;


}
