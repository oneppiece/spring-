package AOP.section4inSpring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class GreetingAroundAdvice implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] arguments = invocation.getArguments();
		String clientName = (String) arguments[0];
		System.out.println("How Are You!" + clientName);
		Object proceed = invocation.proceed();
		System.out.println("Enjoy Your Self!" + clientName);
		return proceed;
	}
}
