package pl.sda.zdjavapol111_travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.zdjavapol111_travel_agency.service.BoughtTourService;

@Controller
public class BoughtTourController {

    @Autowired
    BoughtTourService boughtTourService;

    @GetMapping(path = "/admin/bought-tours-list")
    public String showListOfBoughtTours(ModelMap modelMap) {
        modelMap.addAttribute("boughtTours", boughtTourService.findAll());
        return "bought-tours-list";
    }
}
