package IOC容器;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"IOC容器", "IOC容器.事件"})
public class MainConfig {

	@Bean
	public User user() {
		User user = new User();
		return user;
	}
}
