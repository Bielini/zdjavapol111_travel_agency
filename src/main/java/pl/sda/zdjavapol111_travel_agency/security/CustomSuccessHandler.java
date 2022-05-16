package pl.sda.zdjavapol111_travel_agency.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            switch (grantedAuthority.getAuthority()) {
                case "ROLE_ADMIN": new DefaultRedirectStrategy().sendRedirect(request, response, "/admin/panel"); break;
                case "ROLE_USER": new DefaultRedirectStrategy().sendRedirect(request, response, "/user/panel"); break;
                default: throw new IllegalStateException("Unrecognized role " + grantedAuthority.getAuthority());
            }
        }
    }
}
