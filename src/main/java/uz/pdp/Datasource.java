package uz.pdp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Datasource {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.user}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public Datasource() {
    }

    @Override
    public String toString() {
        return "Datasource{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
