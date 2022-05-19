package pl.sda.zdjavapol111_travel_agency.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol111_travel_agency.model.BoughtTour;
import pl.sda.zdjavapol111_travel_agency.model.Customer;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.service.TourPurchaseService;
import pl.sda.zdjavapol111_travel_agency.service.TourService;
import pl.sda.zdjavapol111_travel_agency.service.impl.CustomerServiceImpl;


import javax.transaction.Transactional;
import javax.validation.Valid;
import java.math.BigDecimal;


@Slf4j
@Controller
public class TourPurchaseController {

    @Autowired
    private TourPurchaseService tourPurchaseService;

    @Autowired
    private CustomerServiceImpl customerService;




    public TourPurchaseController(TourPurchaseService tourPurchaseService, CustomerServiceImpl customerService, TourService tourService) {
        this.tourPurchaseService = tourPurchaseService;
        this.customerService = customerService;
        this.tourService = tourService;

    }

    //    private int adultAmount;
//    private int childAmount;
//    private String name;
//    private String surname;
//    private String email;
    private TourService tourService;


    @Transactional
    @GetMapping(path = "/tours/buy_tour/{id}")
    public String showOrderForm(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("emptyBoughtTour", new BoughtTour());
        modelMap.addAttribute("emptyCustomer", new Customer());
        modelMap.addAttribute("tour", tourService.getById(id.intValue()));

        modelMap.addAttribute("adultAmount", 0);
        modelMap.addAttribute("childAmount", 0);
        modelMap.addAttribute("name", "");
        modelMap.addAttribute("surname", "");
        modelMap.addAttribute("email", "");

        return "tour-purchase";
    }

    @PostMapping(path = "/tours/save")
    public String handleNewBoughtTour(@Valid @ModelAttribute("emptyBoughtTour") BoughtTour boughtTour,
                                      @ModelAttribute("emptyCustomer") Customer customer,
                                      @ModelAttribute("adultAmount") Integer adultAmount,
                                      @ModelAttribute("childAmount") Integer childAmount,
                                      @ModelAttribute("name") String name,
                                      @ModelAttribute("surname") String surname,
                                      @ModelAttribute("email") String email,
                                      @ModelAttribute("calculatePrice") BigDecimal price,
                                      Errors errors
    ) {
        log.info("Zakupiono wycieczkę: " + boughtTour + "przez: " + customer);

        if (errors.hasErrors()) {
            log.error("Error occurded: " + errors.getFieldErrors());

//        if(childAmount > tour.getMinorSeats() || adultAmount > tour.getAdultSeats()){
//            log.info("Musisz zmniejszyć ilość uczestników wycieczki, nie mamy tylu miejsc");
//          return "tour-purchase";
//        }
            return "tour-purchase";
        }


        tourPurchaseService.save(boughtTour);
        customerService.save(customer);
        System.out.println("działa");
        return "redirect:/tours/bought-tours";
    }


}
