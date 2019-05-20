package AOP.section2jdk;

import java.lang.reflect.Proxy;

public class CurrentMain {
	public static void main(String[] args) {
		ForumService target = new ForumServiceImpl();

		PerformanceHandler handler = new PerformanceHandler(target);
		ForumService proxyInstance = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);

		proxyInstance.removeForum(100);
		proxyInstance.removeTopic(200);

	}
}
