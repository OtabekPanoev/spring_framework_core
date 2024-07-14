package uz.pdp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Application started");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//        context.register(MyConfig.class);
//        context.refresh();

//        MyBean bean = context.getBean(MyBean.class);
//        bean.hi();


//        MyBean bean = context.getBean(MyBean.class);
//        System.out.println(bean);
//        MyBean2 bean2 = context.getBean(MyBean2.class);
//        bean2.hi();

//        Datasource bean = context.getBean(Datasource.class);
//        System.out.println(bean);

//        Environment env = context.getEnvironment();
//        System.out.println(env.getProperty("spring.datasource.password"));
//        System.out.println(env.getProperty("spring.datasource.user"));
//        System.out.println(env.getProperty("spring.datasource.url"));

//        Datasource bean = context.getBean(Datasource.class);
//        System.out.println(bean);


//        Map<String, Object> systemEnvironment = context.getEnvironment()
//                .getSystemProperties();
//
//        systemEnvironment.forEach((key, value) -> {
//            System.out.println(key + "=" + value);
//        });

//        Environment environment = context.getEnvironment();
//        System.out.println(environment.getProperty("spring.datasource.url"));

        context.close();
    }
}