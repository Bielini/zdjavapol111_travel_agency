package pl.sda.zdjavapol111_travel_agency.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "redirect:/login";
    }

}
