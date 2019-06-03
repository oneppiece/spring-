package Quartz.spring;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

	/***
	 * 方式一
	 *
	 * @return
	 */
	@Bean
	public JobDetail jobDetailBean() {
		JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("a", 100);
		jobDetailFactoryBean.setJobClass(MySchedlu2.class);
		jobDetailFactoryBean.setName("job2");
		jobDetailFactoryBean.setGroup("group2");
		jobDetailFactoryBean.setJobDataMap(jobDataMap);
		jobDetailFactoryBean.setApplicationContextJobDataKey("app");
		JobDetail jobDetail = jobDetailFactoryBean.getObject();
		return jobDetail;
	}

	@Bean
	public SimpleTrigger simpleTrigger() {

		Map<String, Object> jobMap = new HashMap<String, Object>();
		jobMap.put("abc", 123);
		SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
		simpleTriggerFactoryBean.setJobDetail(jobDetailBean());
		simpleTriggerFactoryBean.setBeanName("simpleTrigger2");
		simpleTriggerFactoryBean.setJobDataAsMap(jobMap);
		simpleTriggerFactoryBean.setRepeatCount(10);
		simpleTriggerFactoryBean.setRepeatInterval(2000);
		simpleTriggerFactoryBean.setStartDelay(5000);
		SimpleTrigger simpleTrigger = simpleTriggerFactoryBean.getObject();
		return simpleTrigger;
	}

	@Bean
	public CronTrigger cronTrigger() {
		CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setCronExpression("0/5 * * * * ?");
		cronTriggerFactoryBean.setBeanName("cronTrigger2");
		CronTrigger cronTrigger = cronTriggerFactoryBean.getObject();
		return cronTrigger;
	}

	@Bean
	public Scheduler scheduler() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "ss");
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setTriggers(simpleTrigger(), cronTrigger());
		schedulerFactoryBean.setSchedulerContextAsMap(map);
		schedulerFactoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));
		return schedulerFactoryBean.getObject();

	}

	//方式2
	@Bean
	@DependsOn({"job1"})
	public JobDetail methodInvokingBean() {
		MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
		methodInvokingJobDetailFactoryBean.setName("job1");
		methodInvokingJobDetailFactoryBean.setGroup("group1");
		methodInvokingJobDetailFactoryBean.setTargetBeanName("job1");
		methodInvokingJobDetailFactoryBean.setTargetMethod("doJob");
		methodInvokingJobDetailFactoryBean.setConcurrent(false);
		JobDetail jobDetailFactoryBeanObject = methodInvokingJobDetailFactoryBean.getObject();
		return jobDetailFactoryBeanObject;
	}
}
