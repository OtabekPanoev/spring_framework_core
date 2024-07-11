package uz.pdp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        System.out.println("Application started");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-conf.xml");
        System.out.println("Before getting context");
//        MyBean bean = context.getBean(MyBean.class);
//        bean.hi();
//
//        MyBean2 bean2 = context.getBean(MyBean2.class);
//        bean2.hi();

        Person bean = context.getBean(Person.class);
        System.out.println(bean);
    }
}
