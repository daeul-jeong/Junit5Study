package me.whiteship.inflearnthejavatest;

import org.junit.jupiter.api.*;

//단위 테스트는 서로간의 의존도가 없어야함.
//순서를 중요하게 생각하면 안됨.
//하지만 순서가 중요할때가 있음. ex) 유스케이스 등..
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestOrder {

	@Test
	@Order(1)
	void create_test() {
		System.out.println(this);
		System.out.println(1);
	}

	@Test
	@Order(2)
	void create_test2() {
		System.out.println(this);
		System.out.println(2);
	}
}
