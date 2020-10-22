package me.whiteship.inflearnthejavatest;

import org.junit.jupiter.api.*;

//
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudyTest2 {
	int value = 0;


	//BeforeAll, AfterAll은 반드시 STATIC 메소드여야함.
	//그런데
	@BeforeAll
	void test() {
		System.out.println("test");

	}

	//클래슫ㅇ 테스트 인스턴스를 만드면 STATIC일 필요가 없ㄱ음.
	@AfterAll
	void test2() {
		System.out.println("test");

	}

	@Test
	@DisplayName("테스트 인스턴스1")
	void create_study() {
		//테스트 메소드마다 클래스 인스턴스 새로 만든다.
		//왜? 테스트 간의 의존성을 없애려고
		//공유하는 값이 있으면서 메소드 실행 순서가 매번 같지 않으면 테스트 값이 불안정해짐.
		//Junit5 에서는 인스턴스 전략을 바꿀 수 있음.
		System.out.println(this);
		Study study = new Study(value++);
		System.out.println(value);
	}

	@Test
	@DisplayName("테스트 인스턴스2")
	void create_study2() {
		Study study = new Study(value++);
		System.out.println(this);
		System.out.println(value);
	}

}
