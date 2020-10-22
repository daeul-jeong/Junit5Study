package me.whiteship.inflearnthejavatest;

import org.junit.Before;
import org.junit.Test;

/*
junit-vintage-engine이 있으면 Junit4 기반으로 할 수 있음.
public class
public method여야함.

Junit 아래의 test 어노테이션 사용

패키지 통째로 실행을 하면 구분해서 보여준다.
Junit Jupiter -> junit5
JUnit Vintage -> junit4

@Rule은 기본적으로 지원하지 않지만, junit-jupiter-migrationsupport 모듈이 제공하는 @EnableRuleMigrationSupport를 사용하면 다음 타입의 Rule을 지원한다.
ExternalResource
Verifier
ExpectedException

완벽히 마이그레이션 되진 않음.

 */
public class Junit4Test {


	@Before
	public void before() {
		System.out.println("before");
	}

	@Test
	public void create() {
		System.out.println("test");
	}

	@Test
	public void create2() {
		System.out.println("test");
	}
}
