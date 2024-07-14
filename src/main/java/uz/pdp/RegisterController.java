package uz.pdp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @GetMapping("/register1")
    public ModelAndView getRegisterView() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute() RegisterDto dto
//            @RequestParam("username") String username,
//            @RequestParam("password") String password
    ) {
        System.out.println(dto);
//        System.out.println(username);
//        System.out.println(password);
        return "redirect:/register1";
    }
}
