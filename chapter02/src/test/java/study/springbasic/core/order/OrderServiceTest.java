package study.springbasic.core.order;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.springbasic.core.AppConfig;
import study.springbasic.core.member.Grade;
import study.springbasic.core.member.Member;
import study.springbasic.core.member.MemberService;

class OrderServiceTest {

	AppConfig appConfig = new AppConfig();

	MemberService memberService;
	OrderService orderService;

	@BeforeEach
	void init() {
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}

	@Test
	void createOrderTest() {
		long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);
		assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}