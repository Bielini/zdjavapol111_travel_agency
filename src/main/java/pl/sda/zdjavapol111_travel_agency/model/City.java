package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Country country;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Hotel> hotels;

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
