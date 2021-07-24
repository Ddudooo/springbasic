package study.springbasic.core.order;

import study.springbasic.core.discount.DiscountPolicy;
import study.springbasic.core.discount.FixDiscountPolicy;
import study.springbasic.core.member.Member;
import study.springbasic.core.member.MemberRepository;
import study.springbasic.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}