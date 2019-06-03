package Quartz.spring;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName CurrentMain
 * @Description TODO
 * @Author duzy
 * @Date 2019-06-03 21:25
 * @Version 1.0
 **/
public class CurrentMain {
	public static void main(String[] args) throws SchedulerException {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	}
}
