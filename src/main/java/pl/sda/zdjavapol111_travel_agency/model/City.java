package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Hotel> hotels;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Airport> airports;

    @OneToMany(mappedBy = "destinationCity", cascade = CascadeType.ALL)
    private List<Tour> toursWithDestinationCity;

    @OneToMany(mappedBy = "originCity", cascade = CascadeType.ALL)
    private List<Tour> toursWithOriginCity;

    @Builder
    private City(Integer id, String name, Country country, List<Hotel> hotels) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.hotels = hotels;
    }

    public City() {
    }
}
