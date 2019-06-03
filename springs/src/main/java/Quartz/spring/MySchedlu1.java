package Quartz.spring;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("job1")
public class MySchedlu1 {
	private static int counter = 0;
	private org.slf4j.Logger logger = LoggerFactory.getLogger("MySchedlu1");

	public void doJob() {
		logger.debug("job开始啦");
		System.out.println("JOB1");
		System.out.println("NOW IS " + System.currentTimeMillis());
		System.out.println("COUNT IS " + (counter++));
	}
}
