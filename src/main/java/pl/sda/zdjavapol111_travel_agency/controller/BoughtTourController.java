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
        modelMap.addAttribute("tour", tourObject);


        return "tour-purchase";
    }

    @Transactional
    @PostMapping(path = "/tours/save")
    public String handleNewBoughtTour(@ModelAttribute("emptyBoughtTour") BoughtTour boughtTour,
                                      @ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        log.info("Dodano klienta: " + customer);

        tourService.save(tourObject, boughtTour);

        boughtTourService.save(boughtTour, customer, tourObject);
        log.info("Zakupiono wycieczkę: " + boughtTour);

        return "/bought-tour";
    }


    @GetMapping(path = "/admin/bought-tours-list")
    public String showListOfBoughtTours(ModelMap modelMap) {
        modelMap.addAttribute("boughtTours", boughtTourService.findAll());
        return "bought-tours-list";
    }


}