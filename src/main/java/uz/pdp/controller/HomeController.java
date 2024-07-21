package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/v1")
    public String home() {
        return "home";
    }

    @GetMapping("/v2")
    public String homeV2() {
        return "home";
    }
}
