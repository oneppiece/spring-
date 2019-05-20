package IOC容器.事件;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.*;
import org.springframework.stereotype.Component;

@Component
public class MyEventPublisher implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	/**
	 * Set the ApplicationContext that this object runs in.
	 * Normally this call will be used to initialize the object.
	 * <p>Invoked after population of normal bean properties but before an init callback such
	 * as {@link InitializingBean#afterPropertiesSet()}
	 * or a custom init-method. Invoked after {@link ResourceLoaderAware#setResourceLoader},
	 * {@link ApplicationEventPublisherAware#setApplicationEventPublisher} and
	 * {@link MessageSourceAware}, if applicable.
	 *
	 * @param applicationContext the ApplicationContext object to be used by this object
	 * @throws ApplicationContextException in case of context initialization errors
	 * @throws BeansException              if thrown by application context methods
	 * @see BeanInitializationException
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void publishEvent(String to) {
		System.out.println("执行操作：" + to);
		MyEventSource myEventSource = new MyEventSource(this.applicationContext, to);
		applicationContext.publishEvent(myEventSource);

	}

}
