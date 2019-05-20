package AOP.section4inSpring;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName GreetingBeforeAdvice
 * @Description TODO
 * @Author duzy
 * @Date 2019-05-20 22:23
 * @Version 1.0
 **/
@Component
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("How Are you!");
        System.out.println(method.toString());
        System.out.println(args.toString());
        System.out.println(target.toString());
    }
}
