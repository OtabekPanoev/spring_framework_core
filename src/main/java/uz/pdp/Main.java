package uz.pdp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        System.out.println("Application started");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("Before Getting Bean from Context");

        MyBean bean = context.getBean(MyBean.class);
        System.out.println(bean);
        MyBean2 bean2 = context.getBean(MyBean2.class);
        bean2.hi();


    }
}