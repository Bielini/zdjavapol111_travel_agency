package pl.sda.zdjavapol111_travel_agency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.repository.CityRepository;
import pl.sda.zdjavapol111_travel_agency.repository.HotelRepository;
import pl.sda.zdjavapol111_travel_agency.repository.TourRepository;
import pl.sda.zdjavapol111_travel_agency.service.*;

import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.service.TourService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class TourController {


    private TourService tourService;

    private List<Tour> filteredTours;

    private CityService cityService;

    private AirportService airportService;

    private HotelService hotelService;


    public TourController(TourService tourService, CityService cityService,
                          AirportService airportService, HotelService hotelService) {
        this.tourService = tourService;
        this.filteredTours = tourService.getAllTours();
        this.cityService = cityService;
        this.airportService = airportService;
        this.hotelService = hotelService;
    }

    @GetMapping(path = "/tours")
    public String tourList(ModelMap modelMap) {
        modelMap.addAttribute("promotedTours", tourService.get2PromotedTours());
        modelMap.addAttribute("tours", tourService.getAllTours());
        modelMap.addAttribute("filteredTours", filteredTours);

        return "tour-list";
    }

    @PostMapping("/tours/filter")
    public String handleNewUserByAdmin(@RequestParam("filter") String filter, @RequestParam("searchField") String searchField) {
        log.info("Received filter: " + filter + " & value of field: " + searchField);
        this.filteredTours = tourService.filterTours(searchField, filter);
        return "redirect:/tours";
    }


    @GetMapping(path = "/admin/add-tour")
    String showCreateTourForm(ModelMap modelMap) {

        modelMap.addAttribute("emptyTour", new Tour());
        modelMap.addAttribute("destinationCityName", "");
        modelMap.addAttribute("originCityName", "");
        modelMap.addAttribute("cities", cityService.findAll());
        modelMap.addAttribute("airports", airportService.findAll());
        modelMap.addAttribute("originAirportName", "");
        modelMap.addAttribute("destinationAirportName", "");
        modelMap.addAttribute("hotels", hotelService.findAll());
        modelMap.addAttribute("hotelName", "");
        return "tour-create";
    }

    @PostMapping (path = "/admin/save-tour")
    String handleNewTour(@ModelAttribute("emptyTour") Tour tour,
                         @ModelAttribute("destinationCityName") String destinationCityName,
                         @ModelAttribute("originCityName") String originCityName,
                         @ModelAttribute("originAirportName") String originAirportName,
                         @ModelAttribute("destinationAirportName") String destinationAirportName,
                         @ModelAttribute("hotelName") String hotelName) {

        tourService.save(tour, destinationCityName, originCityName, originAirportName, destinationAirportName, hotelName);

        log.info("Handled new tour: " + tour);

        return "redirect:/admin/panel";
    }

}
