package study.springbasic.core.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import study.springbasic.core.member.Grade;
import study.springbasic.core.member.Member;

class RateDiscountPolicyTest {

	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	void rateDiscount_VIPTest() {
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		int discount = discountPolicy.discount(member, 10000);
		assertThat(discount).isEqualTo(1000);
	}

	@Test
	void rateDiscount_NONE_Test() {
		Member member = new Member(1L, "member", Grade.BASIC);
		int discount = discountPolicy.discount(member, 10000);
		assertThat(discount).isEqualTo(0);
	}
}