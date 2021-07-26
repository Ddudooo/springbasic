package study.springbasic.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springbasic.core.AppConfig;
import study.springbasic.core.member.MemberRepository;
import study.springbasic.core.member.MemberServiceImpl;
import study.springbasic.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

	@Test
	void configurationTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

		MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

		System.out
			.println("memberService.memberRepository = " + memberService.getMemberRepository());
		System.out.println("orderService.memberRepository = " + orderService.getMemberRepository());
		System.out.println("memberRepository = " + memberRepository);

		assertThat(memberService.getMemberRepository())
			.isSameAs(memberRepository);

		assertThat(orderService.getMemberRepository())
			.isSameAs(memberRepository);
	}
}