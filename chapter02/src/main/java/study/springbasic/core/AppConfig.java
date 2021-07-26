package study.springbasic.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springbasic.core.discount.DiscountPolicy;
import study.springbasic.core.discount.RateDiscountPolicy;
import study.springbasic.core.member.MemberRepository;
import study.springbasic.core.member.MemberService;
import study.springbasic.core.member.MemberServiceImpl;
import study.springbasic.core.member.MemoryMemberRepository;
import study.springbasic.core.order.OrderService;
import study.springbasic.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		System.out.println("call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}

	@Bean
	public OrderService orderService() {
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(
			memberRepository(),
			discountPolicy()
		);
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		System.out.println("call AppConfig.discountPolicy");
		return new RateDiscountPolicy();
	}
}