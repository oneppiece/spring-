package 缓存.springCache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CurrentMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService) applicationContext.getBean("userService");
		System.out.println("第一次：");
		userService.getUserById("123");
		System.out.println("第二次：");
		userService.getUserById("123");
		userService.evictCache();
		System.out.println("第三次：");
		userService.getUserById("123");
		System.out.println("第四次：");
		userService.getUserById("123");

		System.out.println("第五次：");
		userService.getUserById("12");
		System.out.println("第六次：");
		userService.getUserById("12");

	}
}
