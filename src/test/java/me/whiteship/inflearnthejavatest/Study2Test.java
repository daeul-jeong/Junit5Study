package me.whiteship.inflearnthejavatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

//ReplaceUnderscores 공백을 언더바로 치환해줌
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class Study2Test {
	//특정 test 함수안에 커서를 넣고 테스트시작하면 그 함수만 실행됨
	@Test
	@DisplayName("스터디 만들기")
	//이걸 더 권장함
	@EnabledOnOs(OS.MAC)
	void create() {
		//java_home 설정한 곳 에서 수정 후 인텔리제이 재시작
		//export TEST_ENV=LOCAL
//		assumeTrue("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")));
		//assumingThat 조건에 만족하면 ()-> 한다.
		assumingThat("keesun".equalsIgnoreCase("test"), () -> {
			System.out.println("local");
			Study actual = new Study(100);
			assumeTrue("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")));
		});
//		Study study = new Study(10);
		//TODO assertTimeoutPreemptively() 사용시 ThreadLocal는 쓰레드 공유를 하지 않기때문에 Test할 시 트렌젝션 테스트가 잘 안될 수 있음.
		// assertTimeout이 안전할 수 있음
		//기대값까지만 기다렸다가 결과보여줌
//		assertTimeoutPreemptively(Duration.ofMillis(100), ()-> {
//			new Study(10);
//			Thread.sleep(3000);
//		});

		//단점. 실제 실행 함수의 시간을 그대로 기다렸다 함. 오래걸리는 코드면 그만큼 시간이 걸린다.
//		assertTimeout(Duration.ofMillis(100), ()-> {
//			new Study(10);
//			Thread.sleep(3000);
//		});
		//이 코드를 실행할때 예외가 발생하는지 테스트
//		assertThrows(IllegalArgumentException.class, ()-> new Study(-10));
//		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> new Study(-10));
//		assertEquals("limit은 0보다 커야 한다.", exception.getMessage());
//		assertAll(
//				() -> assertNotNull(study),
//				// () ->를 하면 실패할때만 메세지를 보여준다. 성능에 유리
//				() -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
//						() -> "스터디를 처음 만들면 상태값이 DRAFT여야한다."),
//				() -> assertTrue(study.getLimit() > 0));

		System.out.println("create");
	}


	@Test
//	@DisabledOnOs(OS.MAC)
	@EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9})
//	@EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
	@Tag("fast")
//Edit Configuration -> Test Kind -> Tags로 설정하고 @Tag 일치하게 적어줌.
	void create1() {
		System.out.println("create1 fast");
	}

	@Test
//	@Tag("slow")
	@FastTest
		// 직접 만든 애노테이션
	void create2() {
		System.out.println("create1 slow");
	}

	@Test
	@SlowTest
		// 직접 만든 애노테이션
	void create2_slow() {
		System.out.println("create1 slow");
	}


	//	@RepeatedTest(10)
	@DisplayName("스터디 만들기")
	@RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
	void repeatTest(RepetitionInfo repetitionInfo) {
		System.out.println("repeat " + repetitionInfo.getCurrentRepetition()
				+ " / "
				+ repetitionInfo.getTotalRepetitions());
	}

	@DisplayName("스터디 만들기")
	@ParameterizedTest(name = "{index} {displayName} message={0}")
	@ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
	void parameterizedTest(String message) {
		System.out.println(message);
	}

	//테스트 실행되기전에 딱 한번 실행됨
	//static void
	@BeforeAll
	static void beforAll() {
		System.out.println("beforAll");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("afterAll");
	}

	@AfterEach
	void AfterEach() {
		System.out.println("AfterEach");
	}

	@BeforeEach
	void BeforeEach() {
		System.out.println("BeforeEach");
	}


}