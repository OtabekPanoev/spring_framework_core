package uz.pdp;


public class MyBean2 {

    private MyBean myBean;

    public MyBean2(MyBean myBean) {
        this.myBean = myBean;
    }

    public void hi() {
        System.out.println("hello from MyBean2");
        System.out.println(myBean);
    }
}
