package IOC容器.事件;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class MyEventSource extends ApplicationContextEvent {

	private String to;

	/**
	 * Create a new ContextStartedEvent.
	 *
	 * @param source the {@code ApplicationContext} that the event is raised for
	 *               (must not be {@code null})
	 */
	public MyEventSource(ApplicationContext source, String to) {
		super(source);
		this.to = to;
	}


	public String getTo() {
		return to;
	}
}
