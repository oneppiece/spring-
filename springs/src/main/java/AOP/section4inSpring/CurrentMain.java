package AOP.section4inSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName CurrentMain
 * @Description TODO
 * @Author duzy
 * @Date 2019-05-20 22:20
 * @Version 1.0
 **/
public class CurrentMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        GreetingService greetingService = (GreetingService) applicationContext.getBean("proxyFactoryBean");
        greetingService.sayHi("tom");
        greetingService.service("jerry");
    }
}
