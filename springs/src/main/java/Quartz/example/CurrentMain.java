package Quartz.example;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.sql.*;

public class CurrentMain {
	public static void main(String[] args) throws SchedulerException, SQLException, ClassNotFoundException {
		runSayDemo();
//		MSJDBC();
	}

	private static void runSayDemo() throws SchedulerException {
		JobDetail jobDetail = JobBuilder.newJob(SayJob.class).withIdentity("job_1", "group_1").build();
		SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity("trigger_1", "group_1").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(50)).build();
		StdSchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, simpleTrigger);
	}


	private static void MSJDBC() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://192.168.20.142/my_schedule:1433", "sa", "Tenry51885188");
		PreparedStatement preparedStatement = connection.prepareStatement("select 1");
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.close();
		preparedStatement.close();
		connection.close();

	}
}
