package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer standard;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @OneToMany(mappedBy = "destinationHotel", cascade = CascadeType.ALL)
    private List<Tour> tours;

}
