package AOP.section1;

public class ForumServiceImpl implements ForumService {
	public void removeTopic(int topicId) {
		PerformanceMonitor.begin("com.duzy.study.removeTopic");
		System.out.println("模拟删除" + topicId);
		try {
			Thread.currentThread().sleep(200);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		PerformanceMonitor.end();
	}

	public void removeForum(int forumId) {
		PerformanceMonitor.begin("com.duzy.study.removeForum");
		System.out.println("模拟删除" + forumId);
		try {
			Thread.currentThread().sleep(400);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		PerformanceMonitor.end();
	}
}
