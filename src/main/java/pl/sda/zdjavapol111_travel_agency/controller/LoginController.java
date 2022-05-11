package pl.sda.zdjavapol111_travel_agency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(path = "/admin/panel")
    public String showAdminPanel(){
        return "admin-panel";
    }

}
