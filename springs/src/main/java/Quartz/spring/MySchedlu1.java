package Quartz.spring;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("job1")
public class MySchedlu1 implements Serializable {

	private static final long serialVersionUID = -1711135791912607684L;
	
	private static int counter = 0;
	private org.slf4j.Logger logger = LoggerFactory.getLogger("MySchedlu1");

	public void doJob() {
		logger.debug("job开始啦");
		System.out.println("JOB1");
		System.out.println("NOW IS " + System.currentTimeMillis());
		System.out.println("COUNT IS " + (counter++));
	}
}
