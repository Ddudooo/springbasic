package study.springbasic.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import study.springbasic.core.member.MemberRepository;
import study.springbasic.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
	basePackages = "study.springbasic.core",
	basePackageClasses = AutoAppConfig.class,
	excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

	@Bean(name = "memoryMemberRepository")
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}