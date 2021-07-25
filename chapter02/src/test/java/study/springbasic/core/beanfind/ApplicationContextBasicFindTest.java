package study.springbasic.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springbasic.core.AppConfig;
import study.springbasic.core.member.MemberService;
import study.springbasic.core.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);

		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);

		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	void findBeanByName2() {
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);

		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	void findBeanByNameX() {
		assertThrows(NoSuchBeanDefinitionException.class, () -> {
			ac.getBean("xxxx", MemberService.class);
		});
	}
}