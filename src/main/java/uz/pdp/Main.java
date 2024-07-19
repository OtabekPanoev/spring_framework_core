package uz.pdp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new ClassPathXmlApplicationContext("ioc_conf.xml");

        UserRepository userRepository = context.getBean(UserRepository.class);

        User user1 = User.builder()
                .username("username1")
                .password1("password1")
                .age(20)
                .build();
//        userRepository.save(user1);

        System.out.println("userRepository.findById(1) = " + userRepository.findById(1));
//        System.out.println("userRepository.findById2(1) = " + userRepository.findById2(1));

        System.out.println("-----------End----------");
    }
}
