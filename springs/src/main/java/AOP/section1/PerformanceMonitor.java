package AOP.section1;

public class PerformanceMonitor {

	private static ThreadLocal<MethodPerformance> performanceThreadLocal = new ThreadLocal<MethodPerformance>();

	public static void begin(String method) {
		System.out.println("begin monitor...");
		MethodPerformance methodPerformance = new MethodPerformance(method);
		performanceThreadLocal.set(methodPerformance);
	}

	public static void end() {
		System.out.println("end monitor...");
		MethodPerformance methodPerformance = performanceThreadLocal.get();
		methodPerformance.printPerformance();
	}

}
