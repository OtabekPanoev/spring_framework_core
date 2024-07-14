package uz.pdp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.List;

@Controller()
public class HomeController {

    @GetMapping("/home")
    public ModelAndView home() { // rest
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("username", "Najot Pdpda");
        modelAndView.addObject("users", List.of(
//                new User("Aziz", "123", "aziz@gmail.com", 20),
//                new User("Sardor", "321", "sardor@gmail.com", 22),
//                new User("G'olib", "231", "qashqir@gmail.com", 20)
        ));
        return modelAndView;
    }


}
