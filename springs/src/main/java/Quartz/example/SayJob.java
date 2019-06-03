package Quartz.example;

import com.oracle.tools.packager.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class SayJob implements Job {
	private Logger logger = LoggerFactory.getLogger(SayJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.error(context + "triggered. Time is " + new Date());
		System.out.println(context + "triggered. Time is " + new Date());
	}
}
