package 注解;

import java.lang.reflect.Method;

public class CurrentMain {
	public static void main(String[] args) {
		Class<CustomerService> customerServiceClass = CustomerService.class;
		Method[] declaredMethods = customerServiceClass.getDeclaredMethods();
		for (Method declaredMethod : declaredMethods) {
			NeedTest annotation = declaredMethod.getAnnotation(NeedTest.class);
			boolean value = annotation.value();
			System.out.println("method->" + declaredMethod.getName() + "->value:" + value);
		}
	}
}
