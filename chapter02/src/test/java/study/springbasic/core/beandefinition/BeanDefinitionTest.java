package study.springbasic.core.beandefinition;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.springbasic.core.AppConfig;

public class BeanDefinitionTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	//GenericApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

	@Test
	void findApplicationBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println("beanDefinitionName = " + beanDefinitionName);
				printBeanDefinition(beanDefinition);
			}
		}
	}

	private void printBeanDefinition(BeanDefinition beanDefinition) {
		String toString = beanDefinition.toString();
		String[] infos = toString.split(";");
		for (String info : infos) {
			System.out.println(info.trim());
		}
		System.out.println("======================================");
	}
}