package uz.pdp.conf;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.val;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.exceptions.UserNotFoundException;

import java.net.http.HttpRequest;

@ControllerAdvice
public class GlobalHandler {





    @ExceptionHandler(Exception.class)
    public ModelAndView error(HttpServletRequest request, Exception e) {
        ModelAndView error = new ModelAndView("error");
        error.addObject("error_message", e.getMessage());
        error.addObject("url", request.getRequestURI());
        return error;
    }



}
