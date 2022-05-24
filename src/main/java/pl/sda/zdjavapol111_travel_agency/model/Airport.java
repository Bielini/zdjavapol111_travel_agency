package pl.sda.zdjavapol111_travel_agency.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(id, airport.id) && Objects.equals(name, airport.name) && Objects.equals(city, airport.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                '}';
    }

    @Builder
    public Airport(Integer id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}
