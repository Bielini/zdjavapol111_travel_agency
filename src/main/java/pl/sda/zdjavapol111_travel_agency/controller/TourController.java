package pl.sda.zdjavapol111_travel_agency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjavapol111_travel_agency.model.Tour;
import pl.sda.zdjavapol111_travel_agency.repository.CityRepository;
import pl.sda.zdjavapol111_travel_agency.repository.TourRepository;
import pl.sda.zdjavapol111_travel_agency.service.CityService;
import pl.sda.zdjavapol111_travel_agency.service.TourService;

import java.util.List;

@Slf4j
@Controller
public class TourController {


    private TourService tourService;

    private CityService cityService;

    private List<Tour> filteredTours;

    private String activeFilter = "";
    private CityRepository cityRepository;



    public TourController(TourService tourService, CityRepository cityRepository, TourRepository tourRepository, CityService cityService) {
        this.tourService = tourService;
        this.filteredTours = tourService.getAllTours();
        this.cityRepository = cityRepository;
        this.cityService = cityService;
    }

    @GetMapping(path = "/tours")
    public String tourList(ModelMap modelMap) {
        modelMap.addAttribute("promotedTours", tourService.get2PromotedTours());
        modelMap.addAttribute("tours", tourService.getAllTours());
        modelMap.addAttribute("filteredTours", filteredTours);
        modelMap.addAttribute("activeFilter", activeFilter);

        return "tour-list";
    }

    @PostMapping("/tours/filter")
    public String handleNewUserByAdmin(@RequestParam("filter") String filter, @RequestParam("searchField") String searchField) {
        log.info("Received filter: " + filter + " & value of field: " + searchField);
        this.filteredTours = tourService.filterTours(searchField, filter);
        this.activeFilter = tourService.getActiveFilter(searchField,filter);
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

    @GetMapping(path = "/admin/tours/{id}/prom")
    public String flipPromTour(@PathVariable Integer id){
        Tour tour = tourService.getById(id);
        tourService.updatePromById(id,!tour.getPromotion());
        log.info("Received: " + id +" ,and change tour to promoted: "+ !tour.getPromotion());
        return "redirect:/tours";
    }
    @GetMapping(path = "/admin/tours/{id}/delete")
    public String deleteTour(@PathVariable Integer id){
        tourService.deleteById(id);
        log.info("Deleted tour of id: " + id);
        filteredTours=tourService.getAllTours();
        activeFilter = "";
        return "redirect:/tours";
    }

    @GetMapping(path = "/admin/tours/{id}/edit")
    public String showEditTourForm(@PathVariable Integer id,ModelMap modelMap){
        modelMap.addAttribute("oldTour",tourService.getById(id));
        modelMap.addAttribute("newTour", new Tour());
        modelMap.addAttribute("cities", cityService.findAll());

        return "tour-edit";
    }

    @PostMapping(path = "/admin/tours/{id}/update")
    public String handleUpdatedTour(
            @PathVariable() Integer id,
            @ModelAttribute(name = "originCity") String originCity,
            @ModelAttribute(name = "adultSeats") Integer adultSeats){

        log.info(id+originCity+adultSeats);

        return "redirect:/admin/tours/{id}/edit";
    }
}
