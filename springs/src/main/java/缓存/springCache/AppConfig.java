package 缓存.springCache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableCaching
@ComponentScan
public class AppConfig {
	@Bean
	public ConcurrentMapCacheFactoryBean defaultMapCacheFactoryBean() {
		ConcurrentMapCacheFactoryBean concurrentMapCacheFactoryBean = new ConcurrentMapCacheFactoryBean();
		concurrentMapCacheFactoryBean.setName("default");
		return concurrentMapCacheFactoryBean;

	}

	@Bean
	public ConcurrentMapCacheFactoryBean userMapCacheFactoryBean() {
		ConcurrentMapCacheFactoryBean concurrentMapCacheFactoryBean = new ConcurrentMapCacheFactoryBean();
		concurrentMapCacheFactoryBean.setName("user");
		return concurrentMapCacheFactoryBean;

	}

	@Bean
	public SimpleCacheManager simpleCacheManager() {
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		Set caches = new HashSet();
		caches.add(defaultMapCacheFactoryBean().getObject());
		caches.add(userMapCacheFactoryBean().getObject());
		simpleCacheManager.setCaches(caches);
		return simpleCacheManager;

	}
}
