package study.springbasic.core.order;

import org.springframework.stereotype.Component;
import study.springbasic.core.discount.DiscountPolicy;
import study.springbasic.core.member.Member;
import study.springbasic.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

	// 스프링빈은 생성자가 딱 1개 존재할때 @Autowired 생략해도 자동 주입
	// @Autowired
	public OrderServiceImpl(MemberRepository memberRepository,
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