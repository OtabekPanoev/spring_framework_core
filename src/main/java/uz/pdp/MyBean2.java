package uz.pdp;

import org.springframework.beans.factory.annotation.Autowired;

public class MyBean2 {

    private MyBean myBean;

    public void hi() {
        System.out.println("Hi from My Bean2");
        System.out.println(myBean);
    }

    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }
}
