package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @OneToOne(fetch = FetchType.LAZY)
    private City city;

}
