package AOP.section4inSpring;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class FooExceptionAdvice implements ThrowsAdvice {
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable{
		System.out.println(method.getName());
		for (Object arg : args) {
			System.out.println(arg);
		}
		System.out.println(target);
		System.out.println(ex);

	}
}
