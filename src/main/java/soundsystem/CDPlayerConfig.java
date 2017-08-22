package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by vern on 2017/7/13.
 */
@Configuration
 @ComponentScan("soundSystem")
// @ComponentScan(basePackages="soundSystem")
// @ComponentScan(basePackages={"soundSystem","video"})
// @ComponentScan(basePackageClasses={CDPlayer.class})
// 使

@Import(CDPlayerConfig.class)
@ImportResource("classpath:cd-config.xml")
public class CDPlayerConfig {

//	@Bean(name = "sgtPepeers")
//	public CompactDisc sgtPeppers() {
//		return new SgtPeppers();
//	}

	/*
	 * Bean注解会告诉Spring这个方法将会返回一个对象，该对象要注册为Spring应用上下文的bean,必须要返回一个对象。
	 * 这样可以利用java做很多事情，只要最后能给返回一个对象即可
	 */
//	@Bean
//	public CompactDisc randomBeatlesCD() {
//
//		int choice = (int) Math.floor(Math.random() * 4);
//		if (0 == choice) {
//			return new SgtPeppers();
//		} else {
//			return new SgtPeppers();
//		}
//
//	}

	/*
	 *Spring调用cdPlayerr()创建cdPlayerrbean的时候，它会自动装配一个CompactDis到配置方法中。
	 *它的优势是：不要求在一个xml文件中。 
	 */
//	@Bean
//	public CDPlayer cdPlayerr(CompactDisc compactDisc) {
//
//		// return new cdPlayerr(sgtPeppers());
//		return new cdPlayerr(compactDisc);
//	}
//
//	
//	/*
//	 * 这是利用调用sgtPeppers()。默认情况下，Spring应用上下文的bean都是单例的。所以，Spring会拦截带有@Bean的方法的调用，
//	 * 并返回的是Spring之前创建的bean。
//	 */
//	@Bean
//	public CDPlayer anotherCDPlayer() {
//		return new cdPlayerr(sgtPeppers());
//	}
//	
	

	
	
	
	
	

}
