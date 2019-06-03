package 缓存.原始;

import org.springframework.util.ObjectUtils;

public class UserService {
	private CacheManager<User> cacheManager;

	public UserService() {
		cacheManager = new CacheManager<User>();
	}

	public User getUserById(String userId) {
		User user = cacheManager.getValue(userId);
		if (!ObjectUtils.isEmpty(user)) {
			System.out.println("从缓存取");
			return user;
		} else {
			user = getFromDB(userId);
			if (!ObjectUtils.isEmpty(user)) {
				cacheManager.addOrUpdateCache(userId, user);
			}
			return user;
		}

	}

	private User getFromDB(String userId) {
		System.out.println("从DB取");
		return new User(userId);
	}

	public void reload() {
		cacheManager.evictCache();
	}
}
