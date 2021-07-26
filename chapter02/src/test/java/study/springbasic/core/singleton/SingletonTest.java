package study.springbasic.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import study.springbasic.core.AppConfig;
import study.springbasic.core.member.MemberService;

public class SingletonTest {

	@Test
	void pureContainer() {
		AppConfig appConfig = new AppConfig();

		MemberService memberService1 = appConfig.memberService();

		MemberService memberService2 = appConfig.memberService();

		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);

		assertThat(memberService1).isNotSameAs(memberService2);
	}

	@Test
	void singletonServiceTest() {
		SingletonService singletonService1 = SingletonService.getInstance();
		SingletonService singletonService2 = SingletonService.getInstance();

		System.out.println("singletonService1 = " + singletonService1);
		System.out.println("singletonService2 = " + singletonService2);

		assertThat(singletonService1).isSameAs(singletonService2);
	}
}