package 缓存.springCache;

public interface UserService {
	User getUserById(String userId);
	void evictCache();
}
