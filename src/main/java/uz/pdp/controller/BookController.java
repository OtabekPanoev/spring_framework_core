package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping
    public ModelAndView book() {
        ModelAndView modelAndView = new ModelAndView("book");
        return modelAndView;
    }
}
