package study.springbasic.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springbasic.core.discount.DiscountPolicy;
import study.springbasic.core.discount.RateDiscountPolicy;
import study.springbasic.core.member.MemberService;
import study.springbasic.core.member.MemberServiceImpl;
import study.springbasic.core.member.MemoryMemberRepository;
import study.springbasic.core.order.OrderService;
import study.springbasic.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(getMemberRepository());
	}

	@Bean
	public MemoryMemberRepository getMemberRepository() {
		return new MemoryMemberRepository();
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(
			getMemberRepository(),
			discountPolicy()
		);
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
	}
}