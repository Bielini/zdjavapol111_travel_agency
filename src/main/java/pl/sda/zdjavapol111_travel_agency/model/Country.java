package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Continent continents;

    @OneToMany(fetch = FetchType.LAZY)
    private List<City> cities;

    @Builder
    public Country(Integer id, String name, Continent continents) {
        this.id = id;
        this.name = name;
        this.continents = continents;
    }
}
