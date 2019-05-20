package AOP.section4inSpring;

import org.springframework.stereotype.Service;

/**
 * @ClassName GreetingService
 * @Description TODO
 * @Author duzy
 * @Date 2019-05-20 22:25
 * @Version 1.0
 **/

public interface GreetingService {
    public void sayHi(String name);

    public void service(String name);
}
