package AOP.section4inSpring;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;

/**
 * @ClassName AnnotationConfig
 * @Description TODO
 * @Author duzy
 * @Date 2019-05-20 22:21
 * @Version 1.0
 **/
@Configuration
@ComponentScan
public class AnnotationConfig {

    @Bean
    public ProxyFactoryBean proxyFactoryBean(@Autowired GreetingServiceImpl greetingService) {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        try {
            proxyFactoryBean.setProxyInterfaces(GreetingService.class.getInterfaces());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        proxyFactoryBean.setInterceptorNames("greetingBeforeAdvice");
        proxyFactoryBean.setTarget(greetingService);
//        proxyFactoryBean.setSingleton(true);
//        proxyFactoryBean.setOptimize(true);
        proxyFactoryBean.setProxyTargetClass(true);
        return proxyFactoryBean;
    }
}
