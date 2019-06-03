package 缓存.springCache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Cacheable(cacheNames = "user")
	public User getUserById(String userId) {
		缓存.springCache.User user = getFromDB(userId);
		return user;

	}

	private User getFromDB(String userId) {
		System.out.println("从DB取");
		return new User(userId);
	}

	@CacheEvict(cacheNames = "user")
	public void evictCache() {
		System.out.println("清空了");
	}

}
