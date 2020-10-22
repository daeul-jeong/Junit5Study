package me.whiteship.inflearnthejavatest;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;

public class FindSlowTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

//	private static final long THRESHOLD = 1000L;
	private long THRESHOLD = 1000L;

	public FindSlowTestExtension(long THRESHOLD){
		this.THRESHOLD = THRESHOLD;
	}
	@Override
	public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
		ExtensionContext.Store store = getStore(extensionContext);
		store.put("START_TIME", System.currentTimeMillis());
	}

	@Override
	public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
		String testMethodNAme = extensionContext.getRequiredTestMethod().getName();

		//자바의 리플렉션 개념
		Method requiredTestMethod = extensionContext.getRequiredTestMethod();
		SlowTest annotation = requiredTestMethod.getAnnotation(SlowTest.class);
		ExtensionContext.Store store = getStore(extensionContext);
		Long start_time = store.remove("START_TIME", long.class);
		long duration = System.currentTimeMillis() - start_time;
		if (duration > THRESHOLD && annotation == null) {
			System.out.printf("please consider mark method [%s] with @SlowTest.\n", testMethodNAme);
		}
	}

	private ExtensionContext.Store getStore(ExtensionContext context) {
		String testClassName = context.getRequiredTestClass().getName();
		String testMethodNAme = context.getRequiredTestMethod().getName();
		return context.getStore(ExtensionContext.Namespace.create(testClassName, testMethodNAme));

	}
}
