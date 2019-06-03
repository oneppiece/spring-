package Quartz.example;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

public class RePairSayHiSchedule {
	public static void main(String[] args) throws SchedulerException {
		StdSchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();

		TriggerKey triggerKey = new TriggerKey("trigger_1", "group_1");
		Trigger trigger = scheduler.getTrigger(triggerKey);

		scheduler.rescheduleJob(triggerKey, trigger);
		scheduler.start();

	}
}
