package 缓存.原始;

import java.io.Serializable;

public class User implements Serializable {


	private static final long serialVersionUID = -5032233944005847690L;
	private String userId;
	private String userName;
	private int age;

	public User(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
