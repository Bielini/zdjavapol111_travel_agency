package pl.sda.zdjavapol111_travel_agency.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private TourService tourService;


    private List<Tour> filteredTours;


    public TourController(TourService tourService) {
        this.tourService = tourService;
        this.filteredTours = tourService.getAllTours();
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

        try {
            this.filteredTours = filterTours(searchField, filter);
        } catch (IllegalArgumentException e) {
            return "redirect:/tours";
        }
        return "redirect:/tours";
    }

    private List<Tour> filterTours(String searchField, String filter) throws IllegalArgumentException {

        switch (filter) {
            case "destinationCity":
                return tourService.getToursByDestCity(searchField);
            case "originCity":
                return tourService.getToursByOriginCity(searchField);
            case "durationTime":
                return tourService.getToursByDurationTime(Integer.parseInt(searchField));
        }
        return Collections.emptyList();
    }
}
