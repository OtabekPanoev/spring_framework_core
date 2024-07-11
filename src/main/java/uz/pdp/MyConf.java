package uz.pdp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConf {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public MyBean2 myBean2(MyBean myBean) {
        return new MyBean2(myBean);
    }

    @Bean
    public MyBean3 myBean3() {
        return new MyBean3(myBean());
    }

}
