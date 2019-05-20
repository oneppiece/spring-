package AOP.section4inSpring;

import org.springframework.stereotype.Service;

/**
 * @ClassName GreetingServiceImpl
 * @Description TODO
 * @Author duzy
 * @Date 2019-05-20 22:26
 * @Version 1.0
 **/
@Service("greetingService")
public class GreetingServiceImpl implements GreetingService {
    public void sayHi(String name) {
        System.out.println("hi," + name);
    }

    public void service(String name) {
        System.out.println("service," + name);
    }
}
