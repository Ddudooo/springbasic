package study.springbasic.core.order;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import study.springbasic.core.discount.FixDiscountPolicy;
import study.springbasic.core.member.Grade;
import study.springbasic.core.member.Member;
import study.springbasic.core.member.MemoryMemberRepository;

public class OrderServiceImplTest {

	@Test
	void createOrder() {
		MemoryMemberRepository memberRepository = new MemoryMemberRepository();
		memberRepository.save(new Member(1L, "name", Grade.VIP));
		OrderServiceImpl orderService = new OrderServiceImpl(memberRepository,
			new FixDiscountPolicy());
		Order order = orderService.createOrder(1L, "itemA", 1000);

		assertThat(order.getDiscountPrice()).isEqualTo(100);
	}
}