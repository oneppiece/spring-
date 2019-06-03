package AOP.section4inSpring;

import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component("fooService")
public class FooServiceImpl implements FooService {
	public void doIt(String it) {
		throw new RuntimeException("我出异常喽");
	}

	public void justDoIt(String it) throws SQLException {
		throw new SQLException("我又出异常喽");
	}
}
