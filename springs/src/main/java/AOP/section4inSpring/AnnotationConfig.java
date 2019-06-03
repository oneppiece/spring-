package AOP.section4inSpring;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName AnnotationConfig
 * @Description TODO
 * @Author duzy
 * @Date 2019-05-20 22:21
 * @Version 1.0
 **/
@Configuration
@ComponentScan
@EnableAspectJAutoProxy()
public class AnnotationConfig {

	@Bean
	public ProxyFactoryBean proxyFactoryBean(@Autowired GreetingServiceImpl greetingService, @Autowired FooServiceImpl fooService) throws ClassNotFoundException {
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setProxyInterfaces(FooService.class.getInterfaces());
		proxyFactoryBean.setInterceptorNames("fooExceptionAdvice");
		proxyFactoryBean.setTarget(fooService);
		proxyFactoryBean.setSingleton(true);
		proxyFactoryBean.setOptimize(true);
		proxyFactoryBean.setProxyTargetClass(true);
		return proxyFactoryBean;
	}
}
