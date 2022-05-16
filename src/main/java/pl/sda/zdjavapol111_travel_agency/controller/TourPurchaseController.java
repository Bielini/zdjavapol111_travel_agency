package pl.sda.zdjavapol111_travel_agency.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.service.TourPurchaseService;

import javax.transaction.Transactional;
import java.math.BigDecimal;


@Slf4j
@Controller
public class TourPurchaseController {

    @Autowired
    private TourPurchaseService tourPurchaseService;


    private int adultAmount;
    private int childAmount;
    private Tour tour;
    private BigDecimal tourvalueAdult;
    private BigDecimal tourvalue;


    @Transactional
    @GetMapping(path = "/buy_tour/{id}")
    public String showOrderForm(@PathVariable Long id, ModelMap modelMap) {
        tour = tourPurchaseService.getById(id);
        modelMap.addAttribute("tour", tour);
        modelMap.addAttribute("origincityname", tourPurchaseService.getCityNameById(tour.getOriginCity().getId()));
        modelMap.addAttribute("originairport", tourPurchaseService.getAirportNameById(tour.getOriginAirport().getId()));
        modelMap.addAttribute("destinationcity", tourPurchaseService.getCityNameById(tour.getDestinationCity().getId()));
        modelMap.addAttribute("destinationairport", tourPurchaseService.getAirportNameById(tour.getDestinationAirport().getId()));
        modelMap.addAttribute("destinationhotel", tourPurchaseService.getHotelNameById(tour.getDestinationHotel().getId()));
        modelMap.addAttribute("datefrom", tourPurchaseService.getStartDateById(id));
        modelMap.addAttribute("dateto",tourPurchaseService.getEndDateById(id));
        modelMap.addAttribute("adultseats", tourPurchaseService.getAdultSeatsById(id));
        modelMap.addAttribute("minorSeats",tourPurchaseService.getMinorSeatsById(id));
        modelMap.addAttribute("adultsprice",tourPurchaseService.getAdultPriceById(id));
        modelMap.addAttribute("minorprice",tourPurchaseService.getMinorPriceById(id));
        modelMap.addAttribute("adultamount", adultAmount);
        modelMap.addAttribute("childamount", childAmount);

        return "tour-purchase";

    }

//    @RequestMapping(value = "/Pokaż", method = RequestMethod.GET)
//    public Integer handleAmount(@RequestParam String action, ModelMap modelMap){
//        if(action.equals("calculate")){
//        modelMap.replace("origincityname", modelMap(adultAmount));
//        }
//        return "tour-purchase";
//    }



    @RequestMapping(value = "/buy_tour/{id}")
    public String handlePeopleAmount(@RequestParam("adultamount") Integer adultamount, @RequestParam("childamount") Integer childamount, ModelMap modelMap){
    this.adultAmount = adultamount;
    this.childAmount = childamount;
        if(childamount ==0 || childamount == null){
           tourvalue = tour.getAdultPrice().multiply(new BigDecimal(adultamount));
        } tourvalueAdult = tour.getAdultPrice().multiply(new BigDecimal(adultamount));
        tourvalue = tourvalueAdult.add(tour.getMinorPrice().multiply(new BigDecimal(childamount)));

        modelMap.addAttribute("tourvalue", tourvalue);
        modelMap.addAttribute("tour", tour);
        modelMap.addAttribute("origincityname", tourPurchaseService.getCityNameById(tour.getOriginCity().getId()));
        modelMap.addAttribute("originairport", tourPurchaseService.getAirportNameById(tour.getOriginAirport().getId()));
        modelMap.addAttribute("destinationcity", tourPurchaseService.getCityNameById(tour.getDestinationCity().getId()));
        modelMap.addAttribute("destinationairport", tourPurchaseService.getAirportNameById(tour.getDestinationAirport().getId()));
        modelMap.addAttribute("destinationhotel", tourPurchaseService.getHotelNameById(tour.getDestinationHotel().getId()));
        modelMap.addAttribute("datefrom", tourPurchaseService.getStartDateById(tour.getId()));
        modelMap.addAttribute("dateto",tourPurchaseService.getEndDateById(tour.getId()));
        modelMap.addAttribute("adultseats", tourPurchaseService.getAdultSeatsById(tour.getId()));
        modelMap.addAttribute("minorSeats",tourPurchaseService.getMinorSeatsById(tour.getId()));
        modelMap.addAttribute("adultsprice",tourPurchaseService.getAdultPriceById(tour.getId()));
        modelMap.addAttribute("minorprice",tourPurchaseService.getMinorPriceById(tour.getId()));
        modelMap.addAttribute("adultamount", adultAmount);
        modelMap.addAttribute("childamount", childAmount);
        return "tour-purchase";
    }


//    public String handleNewOrder(@Valid @ModelAttribute("emptyOrder") TourPurchase tourPurchase, Errors errors) {
//        log.info("Handle new order: " + tourPurchase);
//
//
//        if (errors.hasErrors()) {
//            log.error("Error occurded: " + errors.getFieldErrors());
//            return "tour-purchase";
//        }
//
//        tourPurchaseService.save(new BoughtTour()); //???
//        return "redirect:/bought";
//    }
}
