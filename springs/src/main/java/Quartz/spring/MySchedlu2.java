package Quartz.spring;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component("job2")
public class MySchedlu2 implements Job {

	public MySchedlu2() {

	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("JOB2");
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		int a = (Integer) jobDataMap.get("a");
//		int abc = (Integer) jobDataMap.get("abc");
//		ApplicationContext applicationContext = (ApplicationContext) jobDataMap.get("app");
		System.out.println("a: " + a);
//		System.out.println("abc: " + abc);
//		System.out.println("applicationContext: " + applicationContext);
		jobDataMap.put("a", a + 1);

	}
}
