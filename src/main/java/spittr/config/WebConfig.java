package spittr.config;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.IOException;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.restdocs.templates.TemplateResourceResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.spring3.templateresolver.*;


@Configuration
@EnableWebMvc
@ComponentScan("spitter.web")
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		return resolver;
		
	}
	
	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
	}
	
	@Bean MessageSource messageSource2() {
		ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasename("file:///etc/spittr/message");
		messageSource.setCacheSeconds(10);
		return messageSource;
		
	}
	
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer=new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] {"/WEB_INF/layout.tiles.xml"});
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
		
		
	}
	
	@Bean
	public ViewResolver viewResolver1() {
		return new TilesViewResolver();
	}
	
	
	/*
	 * Thymeleaf 配置
	 */
	
	
	
	/*
	 * Thymeleaf视图解析器
	 */
	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		return viewResolver;
	}
	
//	@Bean
//	public SpringTemplateEngine templateEngine(TemplateResourceResolver templateResolver) {
//	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//	    templateEngine.setTemplateResolver(templateResolver);
//	    return templateEngine;
//	  }
//	

	@Bean
	public MultipartResolver multipartResolver()throws IOException{
		return new StandardServletMultipartResolver();
	}
	
	
	@Bean
	public MultipartResolver multipartResolver2() throws IOException{
		CommonsMultipartResolver commonsMultipartResolver =new CommonsMultipartResolver();
		commonsMultipartResolver.setUploadTempDir(new FileSystemResource("/tmp/spittr/uploads"));
		commonsMultipartResolver.setMaxUploadSizePerFile(0);
		return commonsMultipartResolver;
	}
	
	
	
}//会构建应用的Web层，创建展现Spittle的控制器以及处理用户注册成为Spitter的表单。
