package pl.sda.zdjavapol111_travel_agency.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol111_travel_agency.model.*;
import pl.sda.zdjavapol111_travel_agency.service.impl.CustomerServiceImpl;
import pl.sda.zdjavapol111_travel_agency.service.impl.BoughtTourServiceImpl;
import pl.sda.zdjavapol111_travel_agency.service.impl.TourServiceImpl;


import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;


@Slf4j
@Controller
public class BoughtTourController {

    @Autowired
    private BoughtTourServiceImpl boughtTourService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private TourServiceImpl tourService;
    private Tour tourObject;




    public BoughtTourController(BoughtTourServiceImpl boughtTourService, CustomerServiceImpl customerService, TourServiceImpl tourService) {
        this.boughtTourService = boughtTourService;
        this.customerService = customerService;
        this.tourService = tourService;
    }



    @Transactional
    @GetMapping(path = "/tours/buy_tour/{id}")
    public String showOrderForm(@PathVariable Integer id, ModelMap modelMap) {
        BoughtTour boughtObject = new BoughtTour();
        tourObject = tourService.getById(id);
        boughtObject.setTour(tourObject);
        modelMap.addAttribute("emptyBoughtTour", boughtObject);
        modelMap.addAttribute("customer", new Customer());
        modelMap.addAttribute("tour", tourObject); //znieniłam typ pola id w modelu z Longa na Intiger

        return "tour-purchase";
    }

    @Transactional
    @PostMapping(path = "/tours/save")
    public String handleNewBoughtTour(@ModelAttribute("emptyBoughtTour") BoughtTour boughtTour,
                                      @ModelAttribute("customer") Customer customer
//                                      ,@ModelAttribute("tour") Tour tourObject


//                                      Errors errors
    ) {
//
        log.info("wynik {} {} {} {} {}", boughtTour, customer);

//        if (errors.hasErrors()) {
//            log.error("Error occurded: " + errors.getFieldErrors());
//
////        if(childAmount > tour.getMinorSeats() || adultAmount > tour.getAdultSeats()){
////            log.info("Musisz zmniejszyć ilość uczestników wycieczki, nie mamy tylu miejsc");
////          return "tour-purchase";}
//
//            return "tour-purchase";
//        }

        System.out.println(tourObject.getId());

//        boughtTour.setPrice(new BigDecimal(price));
//        boughtTour.setTour(tourService.getById(Integer.parseInt(id)));

        customerService.save(customer);
        log.info("Dodano klienta: " + customer);
        boughtTour.setCustomer(customer);

        boughtTour.setTour(tourObject);
        tourObject.setAdultSeats(tourObject.getAdultSeats()-boughtTour.getAdultAmount());
        tourObject.setMinorSeats(tourObject.getMinorSeats()-boughtTour.getChildAmount());
        tourService.save(tourObject);
        boughtTourService.save(boughtTour);

        log.info("Zakupiono wycieczkę: " + boughtTour);


        log.info("wynik {} {} {} {} {}" + customer);
        System.out.println("działa");
        return "/bought-tour";
    }


}
