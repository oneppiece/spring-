package 缓存.原始;

public class CurrentMain {
	public static void main(String[] args) {
		UserService userService = new UserService();
		userService.getUserById("123");
		userService.getUserById("123");

		userService.reload();
		System.out.println("清空缓存");

		userService.getUserById("123");
		userService.getUserById("123");


	}
}
