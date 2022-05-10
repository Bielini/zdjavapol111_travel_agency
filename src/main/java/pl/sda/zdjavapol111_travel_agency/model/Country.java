package pl.sda.zdjavapol111_travel_agency.model;

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

    @OneToMany(fetch = FetchType.LAZY)
    private List<Continent> continents;

    @OneToMany(fetch = FetchType.LAZY)
    private List<City> cities;




}
