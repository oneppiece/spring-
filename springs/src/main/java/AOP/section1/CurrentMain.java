package AOP.section1;

public class CurrentMain {
	public static void main(String[] args) {
		ForumService forumService = new ForumServiceImpl();
		forumService.removeForum(1);
		forumService.removeTopic(2);
	}
}
