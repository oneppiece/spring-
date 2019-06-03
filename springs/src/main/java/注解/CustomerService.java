package 注解;


public class CustomerService {
	@NeedTest(value = true)
	void sing() {

	}

	@NeedTest(value = false)
	void dance() {

	}
}
