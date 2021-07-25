package study.springbasic.core.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import study.springbasic.core.AppConfig;

class MemberServiceTest {

	MemberService memberService = new AppConfig().memberService();

	@Test
	void joinTest() {
		//given
		Member member = new Member(1L, "memberA", Grade.VIP);

		//when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);

		//then
		assertThat(member).isEqualTo(findMember);
	}
}