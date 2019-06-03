package Quartz.spring;

import com.zaxxer.hikari.HikariDataSource;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@ComponentScan
@EnableScheduling
public class AppConfig {

	/***
	 * 方式一
	 *
	 * @return
	 */
	@Bean
	public JobDetailFactoryBean jobDetailBean() {
		JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("a", 100);
		jobDetailFactoryBean.setJobClass(MySchedlu2.class);
		jobDetailFactoryBean.setName("my_job2");
		jobDetailFactoryBean.setGroup("group2");
		jobDetailFactoryBean.setDurability(true);
		jobDetailFactoryBean.setJobDataMap(jobDataMap);
//		jobDetailFactoryBean.setApplicationContextJobDataKey("app");
		return jobDetailFactoryBean;
	}

	@Bean
	public SimpleTriggerFactoryBean simpleTrigger() {

		Map<String, Object> jobMap = new HashMap<String, Object>();
		jobMap.put("abc", 123);
		SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
		simpleTriggerFactoryBean.setJobDetail(jobDetailBean().getObject());
		simpleTriggerFactoryBean.setBeanName("simpleTrigger2");
		simpleTriggerFactoryBean.setJobDataAsMap(jobMap);
		simpleTriggerFactoryBean.setRepeatCount(10);
		simpleTriggerFactoryBean.setRepeatInterval(2000);
		simpleTriggerFactoryBean.setStartDelay(5000);
		return simpleTriggerFactoryBean;
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
	public SchedulerFactoryBean scheduler() throws SQLException, SchedulerException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "ss");
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("quartz.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setExposeSchedulerInRepository(true);
		schedulerFactoryBean.setJobDetails(jobDetailBean().getObject());
		schedulerFactoryBean.setTriggers(simpleTrigger().getObject());
		schedulerFactoryBean.setSchedulerContextAsMap(map);
		schedulerFactoryBean.setQuartzProperties(properties);
		schedulerFactoryBean.setDataSource(dataSource());
		schedulerFactoryBean.setAutoStartup(true);
		schedulerFactoryBean.setStartupDelay(5);
		return schedulerFactoryBean;

	}

	//方式2
	@Bean
	@DependsOn({"job1"})
	public JobDetail methodInvokingBean() {
		MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
		methodInvokingJobDetailFactoryBean.setGroup("group1");
		methodInvokingJobDetailFactoryBean.setTargetBeanName("job1");
		methodInvokingJobDetailFactoryBean.setTargetMethod("doJob");
		methodInvokingJobDetailFactoryBean.setConcurrent(false);
		JobDetail jobDetailFactoryBeanObject = methodInvokingJobDetailFactoryBean.getObject();
		return jobDetailFactoryBeanObject;
	}


	@Bean
	public DataSource dataSource() throws SQLException {
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setUsername("root");
		hikariDataSource.setPassword("root");
		hikariDataSource.setLoginTimeout(10);
		hikariDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_schedules");
		return hikariDataSource;
	}
}
