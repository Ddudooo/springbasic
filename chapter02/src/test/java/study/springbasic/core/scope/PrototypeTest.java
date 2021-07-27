package study.springbasic.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

	@Test
	void prototypeBeanTest() {
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(
			PrototypeBean.class);
		System.out.println("find prototype bean1");
		PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
		System.out.println("find prototype bean2");
		PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
		System.out.println("bean1 = " + bean1);
		System.out.println("bean2 = " + bean2);
		assertThat(bean1).isNotSameAs(bean2);
		
		ac.close();
	}

	@Scope("prototype")
	static class PrototypeBean {

		@PostConstruct
		public void init() {
			System.out.println("PrototypeBean.init");
		}

		@PreDestroy
		public void destroy() {
			System.out.println("PrototypeBean.destroy");
		}
	}
}