package study.springbasic.core.autowired;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import study.springbasic.core.member.Member;

public class AutowiredTest {

	@Test
	void AutowiredOption() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(
			TestBean.class);


	}


	static class TestBean {

		// 대상이 없을시 메소드 호출이 안됨
		@Autowired(required = false)
		public void setNoBean1(Member noBean1) {
			System.out.println("noBean1 = " + noBean1);
		}

		// 대상이 없을시 호출은 되나 null로 들어옴
		@Autowired
		public void setNoBean2(@Nullable Member noBean2) {
			System.out.println("noBean1 = " + noBean2);
		}

		// 대상이 없을시 Optional로 감싸서 들어옴
		@Autowired
		public void setNoBean2(Optional<Member> noBean3) {
			System.out.println("noBean1 = " + noBean3);
		}
	}
}