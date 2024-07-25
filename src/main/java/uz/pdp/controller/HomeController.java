package uz.pdp.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.pdp.conf.security.CustomUserDetails;
import uz.pdp.conf.security.SessionUser;
import uz.pdp.model.AuthUser;

@Controller
@RequestMapping("/home")
public class HomeController {

    private SessionUser sessionUser;

    @GetMapping("/me")
    public String read(/*@AuthenticationPrincipal CustomUserDetails customUserDetails*/) {

        AuthUser sessionUser = SessionUser.getSessionUser()
                .orElseThrow();

//        System.out.println("customUserDetails.getAuthUser() = " + customUserDetails.getAuthUser());

        return "home";
    }

    @GetMapping()
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "Admin Page";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
        return "User Page";
    }
}
