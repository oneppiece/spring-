package IOC容器.事件;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventSourceListener implements ApplicationListener<MyEventSource> {
	/**
	 * Handle an application event.
	 *
	 * @param event the event to respond to
	 */
	public void onApplicationEvent(MyEventSource event) {

		System.out.println("收到事件：" + event + event.getTo() + event.getSource());


	}
}
