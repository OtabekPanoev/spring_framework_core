package uz.pdp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        System.out.println("Application started");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConf.class);
        System.out.println("Before Getting Bean from Context");

//        MyBean bean = context.getBean(MyBean.class);
        MyBean bean = (MyBean)context.getBean("myBean");
        bean.hi();

        System.out.println(bean);

        MyBean2 bean2 = context.getBean(MyBean2.class);
        bean2.hi();

        MyBean3 bean3 = context.getBean(MyBean3.class);
        bean3.hi();

    }
}