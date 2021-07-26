package study.springbasic.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StatefulServiceTest {

	@Test
	void statefulServiceSingleTon() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService service1 = ac.getBean(StatefulService.class);
		StatefulService service2 = ac.getBean(StatefulService.class);

		// userA 의 요청
		service1.order("userA", 10000);

		// userB 의 요청
		service2.order("userB", 20000);

		// userA의 조회 요청
		int price = service1.getPrice();
		System.out.println("userA order price = " + price);

		Assertions.assertThat(service1.getPrice()).isEqualTo(20000);
	}

	@Configuration
	static class TestConfig {

		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}
}