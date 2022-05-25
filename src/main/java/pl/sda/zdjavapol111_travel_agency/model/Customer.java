package pl.sda.zdjavapol111_travel_agency.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//import javax.validation.constraints.Null;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Null(message = "Podanie imienia jest obowiązkowe")
    private String name;

//    @Null(message = "Podanie nazwiska jest obowiązkowe")
    private String surname;

//    @Null(message = "Podanie adresu e-mail jest obowiązkowe")
    private String email;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "CUSTOMER_BOUGHT_TOURS",
//                    joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
//                    inverseJoinColumns = @JoinColumn(name = "BOUGHT_TOURS_ID"))
////    private List<BoughtTour> boughtTours;

}
