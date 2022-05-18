package pl.sda.zdjavapol111_travel_agency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.sda.zdjavapol111_travel_agency.repository.UserRepository;
import pl.sda.zdjavapol111_travel_agency.service.UserService;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/admin/users")
    public String showAllRegisteredUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.findAll());
        return "users-list";
    }

    @GetMapping(path = "/admin/delete_user/{id}")
    public String deleteUserByAdmin(@PathVariable Integer id) {
        userService.deleteById(id);
        return "redirect:/admin/users";
    }
}
