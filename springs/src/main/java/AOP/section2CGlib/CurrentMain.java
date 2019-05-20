package AOP.section2CGlib;

import AOP.section2jdk.ForumServiceImpl;

public class CurrentMain {
	public static void main(String[] args) {
		CGLibProxy cgLibProxy = new CGLibProxy();
		ForumServiceImpl forumService = (ForumServiceImpl) cgLibProxy.getProxy(ForumServiceImpl.class);
		forumService.removeForum(111);
		forumService.removeTopic(200);
	}
}
