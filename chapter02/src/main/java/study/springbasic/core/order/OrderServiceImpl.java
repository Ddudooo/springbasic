package study.springbasic.core.order;

import org.springframework.stereotype.Component;
import study.springbasic.core.annotation.MainDiscountPolicy;
import study.springbasic.core.discount.DiscountPolicy;
import study.springbasic.core.member.Member;
import study.springbasic.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

	public OrderServiceImpl(MemberRepository memberRepository,
		@MainDiscountPolicy
			DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}