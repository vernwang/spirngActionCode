package RMI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class RMIConfig {
	
	@Bean
	public RmiServiceExporter rmiServiceExporter(SpitterService spitterService) {
		RmiServiceExporter rmiServiceExporter=new RmiServiceExporter();
		rmiServiceExporter.setService(spitterService);
		rmiServiceExporter.setServiceName("SpitterService");
		rmiServiceExporter.setServiceInterface(SpitterService.class);
		return rmiServiceExporter;
	}
	
	
}
