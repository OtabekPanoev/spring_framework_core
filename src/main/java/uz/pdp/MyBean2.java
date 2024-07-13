package uz.pdp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean2 {

    private MyBean myBean;

    public MyBean2() {
    }

    @Autowired
    public MyBean2(MyBean myBean, String str) {
        this.myBean = myBean;
    }

    public void hi() {
        System.out.println("hello from MyBean2");
        System.out.println(myBean);
    }


//    public void setKetmon(MyBean myBean) {
//        this.myBean = myBean;
//    }
}
