package study.springbasic.core;

import study.springbasic.core.discount.FixDiscountPolicy;
import study.springbasic.core.member.MemberService;
import study.springbasic.core.member.MemberServiceImpl;
import study.springbasic.core.member.MemoryMemberRepository;
import study.springbasic.core.order.OrderService;
import study.springbasic.core.order.OrderServiceImpl;

public class AppConfig {

	public MemberService memberService() {
		return new MemberServiceImpl(new MemoryMemberRepository());
	}

	public OrderService orderService() {
		return new OrderServiceImpl(
			new MemoryMemberRepository(),
			new FixDiscountPolicy()
		);
	}
}