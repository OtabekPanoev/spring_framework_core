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
import uz.pdp.model.AuthUser;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/me")
    public String read(@AuthenticationPrincipal CustomUserDetails customUserDetails) {

        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        *//*System.out.println("userDetails.getUsername() = " + userDetails.getUsername());
        System.out.println("userDetails.getPassword() = " + userDetails.getPassword());
        userDetails.getAuthorities().forEach(System.out::println);*//*

        AuthUser authUser = userDetails.getAuthUser();
        System.out.println(authUser);*/

        System.out.println("customUserDetails.getAuthUser() = " + customUserDetails.getAuthUser());

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
