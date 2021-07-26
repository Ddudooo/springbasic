package study.springbasic.core.discount;

import org.springframework.stereotype.Component;
import study.springbasic.core.annotation.MainDiscountPolicy;
import study.springbasic.core.member.Grade;
import study.springbasic.core.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

	private int discountPercent = 10;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		}
		return 0;
	}
}