package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.pdp.exceptions.UserNotFoundException;

import java.util.Random;

@Controller
public class BookController {

    @GetMapping("/book")
    @ResponseBody
    public String book() {

        if (new Random().nextBoolean()) {
            throw new UserNotFoundException();
        }

        return "book";
    }
}
