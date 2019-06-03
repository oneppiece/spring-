package Quartz.spring;

import org.springframework.stereotype.Component;

@Component("job1")
public class MySchedlu1 {
	private static int counter = 0;

	public void doJob() {
		System.out.println("JOB1");
		System.out.println("NOW IS " + System.currentTimeMillis());
		System.out.println("COUNT IS " + (counter++));
	}
}
