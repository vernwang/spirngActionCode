package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/com/soundsystem/app.properties")
public class ExpressiveConfig {
	
	@Autowired
	Environment environment;
	
	@Bean
	public CompactDisc disc() {
		environment.getProperty("disc.title");
		return new SgtPeppers("","");
		
	}
	
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertyPlaceholderConfigurer();
	}
	
	/*
	 * #{1}
	 * #{T(System).currentTimeMillis()}
	 * #{sgtPeppers.artist}
	 * #{systemProperties['dis.title']}
	 */
	
	
	
	
}
