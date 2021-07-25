package study.springbasic.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springbasic.core.member.Grade;
import study.springbasic.core.member.Member;
import study.springbasic.core.member.MemberService;
import study.springbasic.core.order.Order;
import study.springbasic.core.order.OrderService;

public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new
			AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService =
			applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService",
			OrderService.class);
		long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println("order = " + order);
	}
}