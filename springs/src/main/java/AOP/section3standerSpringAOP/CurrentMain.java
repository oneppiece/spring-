package AOP.section3standerSpringAOP;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class CurrentMain {
	public static void main(String[] args) {
		Waiter target = new NaiveWaiter();
		BeforeAdvice advice = new GreetingBeforeAdvice();

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(advice);
		proxyFactory.addInterface(Waiter.class);
		proxyFactory.setOptimize(true);

		Waiter proxy = (Waiter) proxyFactory.getProxy();
		proxy.greetTo("John");
		proxy.serveTo("Tom");
	}
}
