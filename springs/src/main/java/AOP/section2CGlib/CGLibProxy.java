package AOP.section2CGlib;

import AOP.section2jdk.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {
	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class clazz) {
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	/**
	 * All generated proxied methods call this method instead of the original method.
	 * The original method may either be invoked by normal reflection using the Method object,
	 * or by using the MethodProxy (faster).
	 *
	 * @param obj    "this", the enhanced object
	 * @param method intercepted Method
	 * @param args   argument array; primitive types are wrapped
	 * @param proxy  used to invoke super (non-intercepted method); may be called
	 *               as many times as needed
	 * @return any value compatible with the signature of the proxied method. Method returning void will ignore this value.
	 * @throws Throwable any exception may be thrown; if so, super method will not be invoked
	 * @see MethodProxy
	 */
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		PerformanceMonitor.begin(obj.getClass().getName() + "." + method.getName());
		Object result = proxy.invokeSuper(obj, args);
		PerformanceMonitor.end();
		return result;
	}
}
