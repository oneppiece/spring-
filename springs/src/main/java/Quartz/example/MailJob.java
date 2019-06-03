package Quartz.example;

import com.sun.mail.util.MailSSLSocketFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailJob implements Job {

	public static void main(String[] args) throws SchedulerException {
		JobDetail job = JobBuilder.newJob(MailJob.class).withIdentity("mailJob", "job_2").build();

		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("10/10 * * * * ?");

		Trigger mailTrigger = TriggerBuilder.newTrigger().startNow().withIdentity("mailTrigger").withSchedule(cronScheduleBuilder).build();

		StdSchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, mailTrigger);

	}


	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			this.sendMail();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void sendMail() throws Exception {
		Properties prop = new Properties();
		prop.setProperty("mail.debug", "true");
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.host", "smtp.qq.com");
		prop.setProperty("mail.transport.protocol", "smtp");
		//ssl
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf);
		Session session = Session.getInstance(prop);
		session.setDebug(true);
		Transport ts = session.getTransport();
		ts.connect("smtp.qq.com", "164408623@qq.com", "tirucllvttrebihc");
		Message message = createSimpleMail(session);
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	private MimeMessage createSimpleMail(Session session)
			throws Exception {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("164408623@qq.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("604994079@qq.com"));
		message.setSubject("是冯导还是冯秀儿");
		message.setContent("你好啊！", "text/html;charset=UTF-8");
		return message;
	}
}
