package AOP.section4inSpring;

import java.sql.SQLException;

public interface FooService {
	void doIt(String it);
	void justDoIt(String it) throws SQLException;
}
