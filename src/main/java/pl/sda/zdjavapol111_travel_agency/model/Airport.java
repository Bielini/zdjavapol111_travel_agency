package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @OneToMany(mappedBy = "destinationAirport", cascade = CascadeType.ALL)
    private List<Tour> toursWithDestinationAirport;

    @OneToMany(mappedBy = "originAirport", cascade = CascadeType.ALL)
    private List<Tour> toursWithOriginAirport;
}
