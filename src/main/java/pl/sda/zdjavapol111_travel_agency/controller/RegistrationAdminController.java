package pl.sda.zdjavapol111_travel_agency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.zdjavapol111_travel_agency.model.User;
import pl.sda.zdjavapol111_travel_agency.service.UserService;

@Slf4j
@Controller
public class RegistrationAdminController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/admin/add-admin")
    String showFormToAddAdmin(ModelMap modelMap){
        modelMap.addAttribute("emptyUser", new User());
        return "admin-create";
    }

    @PostMapping(path = "/admin/save-admin")
    String handleNewAdmin(@ModelAttribute("emptyUser") User user) {

        log.info("Received user: " + user);

        if (userService.existsByUsername(user.getUsername())) {
            return "admin-create";
        }

        userService.saveAdmin(user);
        return "redirect:/admin/panel";
    }
}
