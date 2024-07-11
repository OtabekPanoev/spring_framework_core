package uz.pdp;


public class MyBean3 {

    private MyBean myBean;

    public MyBean3(MyBean myBean) {
        this.myBean = myBean;
    }

    public void hi() {
        System.out.println("hello from MyBean3");
        System.out.println(myBean);
    }
}
