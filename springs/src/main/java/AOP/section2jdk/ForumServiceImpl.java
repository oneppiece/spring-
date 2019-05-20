package AOP.section2jdk;

public class ForumServiceImpl implements ForumService {
	public void removeTopic(int topicId) {
		System.out.println("模拟删除" + topicId);
		try {
			Thread.currentThread().sleep(200);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void removeForum(int forumId) {
		System.out.println("模拟删除" + forumId);
		try {
			Thread.currentThread().sleep(400);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
