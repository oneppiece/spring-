package IOC容器;

import IOC容器.事件.MyEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Processer {
	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfig.class);
		MyEventPublisher myEventPublisher = (MyEventPublisher) cxt.getBean("myEventPublisher");
		myEventPublisher.publishEvent("abc");


	}
}
