package study.springbasic.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springbasic.core.discount.DiscountPolicy;
import study.springbasic.core.discount.FixDiscountPolicy;
import study.springbasic.core.discount.RateDiscountPolicy;

public class ApplicationContextExtendsFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
		TestConfig.class);

	@Test
	void findBeanByParentTypeDuplicate() {
		assertThrows(NoUniqueBeanDefinitionException.class, () -> {
			ac.getBean(DiscountPolicy.class);
		});
	}

	@Test
	void findBeanByParentTypeBeanName() {
		DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);

		assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}

	@Test
	void findBeanBySubType() {
		RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
		assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
	}

	@Test
	void findBeanByParentType() {
		Map<String, DiscountPolicy> beansOfType =
			ac.getBeansOfType(DiscountPolicy.class);

		assertThat(beansOfType.size()).isEqualTo(2);

		for (String key : beansOfType.keySet()) {
			System.out.println("key = " + key + " , value = " + beansOfType.get(key));
		}
	}

	@Test
	void findAllBeanByObjectType() {
		Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);

		for (String key : beansOfType.keySet()) {
			System.out.println("key = " + key + " , value = " + beansOfType.get(key));
		}
	}

	@Configuration
	static class TestConfig {

		@Bean
		public DiscountPolicy rateDisCountPolicy() {
			return new RateDiscountPolicy();
		}

		@Bean
		public DiscountPolicy fixDisCountPolicy() {
			return new FixDiscountPolicy();
		}
	}
}