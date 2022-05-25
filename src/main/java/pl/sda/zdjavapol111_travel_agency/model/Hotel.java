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

    @Builder
    public Hotel(Integer id, String name, Integer standard, String description, City city) {
        this.id = id;
        this.name = name;
        this.standard = standard;
        this.description = description;
        this.city = city;
    }

    public Hotel() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id) && Objects.equals(name, hotel.name) && Objects.equals(standard, hotel.standard) && Objects.equals(description, hotel.description) && Objects.equals(city, hotel.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, standard, description, city);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", standard=" + standard +
                ", description='" + description + '\'' +
                ", city=" + city +
                '}';
    }
}
