package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@Data
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "continent", cascade = CascadeType.ALL)
    private List<Country> countries;

    @Builder
    public Continent(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
