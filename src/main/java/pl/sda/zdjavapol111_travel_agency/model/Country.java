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

    @ManyToOne(fetch = FetchType.EAGER)
    private Continent continent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities;

    @Builder
    public Country(Integer id, String name, Continent continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
    }
}
