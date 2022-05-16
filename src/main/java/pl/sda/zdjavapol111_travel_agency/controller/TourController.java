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
import pl.sda.zdjavapol111_travel_agency.repository.TourRepository;
import pl.sda.zdjavapol111_travel_agency.service.CityService;
import pl.sda.zdjavapol111_travel_agency.service.TourService;

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


    public TourController(TourService tourService, CityService cityService) {
        this.tourService = tourService;
        this.filteredTours = tourService.getAllTours();
        this.cityService = cityService;
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
        modelMap.addAttribute("cities", cityService.findAll());
        return "tour-create";
    }

    @PostMapping (path = "/admin/save")
    String handleNewTour(@ModelAttribute("emptyTour") Tour tour) {
        log.info("Handled new tour: " + tour);
        tourService.calculateDuration(tour);
        tourService.save(tour);

        return "redirect:/admin/panel";
    }

}
