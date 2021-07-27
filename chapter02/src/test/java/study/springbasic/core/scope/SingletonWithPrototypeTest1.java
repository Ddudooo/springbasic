package study.springbasic.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest1 {

	@Test
	void prototypeFind() {
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(
			PrototypeBean.class);

		PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
		bean1.addCount();
		assertThat(bean1.getCount()).isEqualTo(1);

		PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
		bean2.addCount();
		assertThat(bean2.getCount()).isEqualTo(1);

		ac.close();
	}

	@Test
	void singletonClientUseProtoType() {
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(
			PrototypeBean.class, ClientBean.class);

		ClientBean client1 = ac.getBean(ClientBean.class);
		int count1 = client1.logic();
		assertThat(count1).isEqualTo(1);

		ClientBean client2 = ac.getBean(ClientBean.class);
		int count2 = client2.logic();
		assertThat(count2).isEqualTo(1);
	}

	@Scope("prototype")
	static class PrototypeBean {

		private int count = 0;

		public void addCount() {
			count++;
		}

		public int getCount() {
			return count;
		}

		@PostConstruct
		public void init() {
			System.out.println("PrototypeBean.init " + this);
		}

		@PreDestroy
		public void destroy() {
			System.out.println("PrototypeBean.destroy " + this);
		}
	}

	static class ClientBean {

		private Provider<PrototypeBean> prototypeBeanProvider;

		@Autowired
		public ClientBean(
			Provider<PrototypeBean> prototypeBeanProvider) {
			this.prototypeBeanProvider = prototypeBeanProvider;
		}

		public int logic() {
			PrototypeBean prototypeBean = prototypeBeanProvider.get();
			prototypeBean.addCount();
			return prototypeBean.getCount();
		}

		@PostConstruct
		public void init() {
			System.out.println("ClientBean.init " + this);
		}

		@PreDestroy
		public void destroy() {
			System.out.println("ClientBean.destroy " + this);
		}
	}
}