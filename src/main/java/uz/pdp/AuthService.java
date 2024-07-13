package uz.pdp;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//@Component
public class AuthService {


    @PostConstruct
    public void init() {
        System.out.println("init AuthService");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy AuthService");
    }


}
