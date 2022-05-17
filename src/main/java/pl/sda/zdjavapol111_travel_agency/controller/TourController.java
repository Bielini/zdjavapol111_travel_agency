package pl.sda.zdjavapol111_travel_agency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.repository.CityRepository;
import pl.sda.zdjavapol111_travel_agency.repository.TourRepository;
import pl.sda.zdjavapol111_travel_agency.service.TourService;

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


    private CityRepository cityRepository;


    public TourController(TourService tourService, CityRepository cityRepository, TourRepository tourRepository) {
        this.tourService = tourService;
        this.filteredTours = tourService.getAllTours();
        this.cityRepository = cityRepository;

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
        modelMap.addAttribute("cities", cityRepository.findAll());
        return "tour-create";
    }

    @PostMapping(path = "/admin/save")
    String handleNewTour(@ModelAttribute("emptyTour") Tour tour) {
        log.info("Handled new tour: " + tour);
        tourService.calculateDuration(tour);
        tourService.save(tour);
        return "redirect:/admin/panel";
    }

    @GetMapping(path = "/tours/{id}")
    public String showTourDescription(@PathVariable Integer id, ModelMap modelMap) {
        Tour tour = tourService.getById(id);
        modelMap.addAttribute("tour", tour);

        return "tour-description";
    }

}
