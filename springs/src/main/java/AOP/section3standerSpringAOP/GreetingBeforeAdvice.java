package AOP.section3standerSpringAOP;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String clientName = (String) args[0];
		System.out.println("How are you! Mr." + clientName);
		System.out.println(target);
	}
}
