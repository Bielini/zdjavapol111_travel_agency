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

@Slf4j
@Controller
public class TourController {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    TourRepository tourRepository;

    @GetMapping(path = "/admin/add-tour")
    String showCreateTourForm(ModelMap modelMap) {
        modelMap.addAttribute("emptyTour", new Tour());
        modelMap.addAttribute("cities", cityRepository.findAll());
        return "tour-create";
    }

    @PostMapping (path = "/admin/save")
    String handleNewTour(@ModelAttribute("emptyTour") Tour tour) {
        log.info("Handled new tour: " + tour);
        tourRepository.save(tour);
        return "redirect:/admin/panel";
    }

}
