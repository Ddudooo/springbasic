package study.springbasic.core.discount;

import study.springbasic.core.member.Member;

public interface DiscountPolicy {
	// 할인 대상 금액 반환
	int discount(Member member, int price);
}
