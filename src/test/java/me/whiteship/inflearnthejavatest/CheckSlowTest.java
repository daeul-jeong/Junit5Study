package me.whiteship.inflearnthejavatest;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

//선언적 등록, 커스텀하게 변수를 넣어 생성자를 만들 수 없음.
//@ExtendWith(FindSlowTestExtension.class)
public class CheckSlowTest {

	//필드 정의, static
	@RegisterExtension
	static FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension(1000L);

	@Test
	@Order(1)
	void create_new_study() throws InterruptedException {
		Thread.sleep(1004L);
		System.out.println("test");

	}
}
