package dataSource;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.jclouds.scriptbuilder.functionloader.filters.LicenseHeaderFilter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
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

import com.mongodb.Mongo;
import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;
import com.sun.jna.platform.win32.DsGetDC.DS_DOMAIN_TRUSTS;

import spittr.data.SpittleRepository;

import org.thymeleaf.spring3.templateresolver.*;


@Configuration
@EnableWebMvc
@ComponentScan("spitter.web")
public class WebConfig extends WebMvcConfigurerAdapter{

	
	@Bean
	public JndiObjectFactoryBean dataSource() {
		JndiObjectFactoryBean inJndiObjectFactoryBean=new JndiObjectFactoryBean();
		inJndiObjectFactoryBean.setJndiName("jdbc/SpittrDS");
		inJndiObjectFactoryBean.setResourceRef(true);
		inJndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
		return inJndiObjectFactoryBean; 
	}
	
	
	@Bean
	public BasicDataSource dataSource2() {
		BasicDataSource basicDataSource=new BasicDataSource();
		basicDataSource.setDriverClassName("org.h2.Driver");
		basicDataSource.setUrl("jdbc:h2:tcp://localhost/~/spitter");
		basicDataSource.setUsername("");
		basicDataSource.setPassword("");
		basicDataSource.setInitialSize(5);
		basicDataSource.setMaxActive(10);
		return basicDataSource;
	}
	
	@Bean
	public DriverManagerDataSource dataSource3() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		return ds;
		
		
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	
	@Bean
	public SpittleRepository spittleRepository(JdbcTemplate jdbcTemplate) {
		return new JdbcSpitterRepository(jdbcTemplate);
	}

	//hibernate: 用XML、且  3.2 <hibernate<4.0 
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setMappingResources(new String[] {"Spitter.hbm.xml"});
		Properties properties=new Properties();
		properties.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
		sessionFactoryBean.setHibernateProperties(properties);
		return sessionFactoryBean;
	}
	
	
	//hibernate:使用注解的方式
	
	@Bean
	public AnnotationSessionFactoryBean sessionFactory2(DataSource dataSource) {
		AnnotationSessionFactoryBean annotationSessionFactoryBean=new AnnotationSessionFactoryBean();
		annotationSessionFactoryBean.setDataSource(dataSource);
		annotationSessionFactoryBean.setPackagesToScan(new String[] {"com.spittr.domain"});
		Properties properties=new Properties();
		properties.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
		annotationSessionFactoryBean.setHibernateProperties(properties);
		
		return annotationSessionFactoryBean;
	}
	
	//hibernate： 支持XML和注解 hibernate 4.
	
	@Bean
	public org.springframework.orm.hibernate4.LocalSessionFactoryBean sessionFactory3(DataSource dataSource) {
		org.springframework.orm.hibernate4.LocalSessionFactoryBean localSessionFactoryBean=new org.springframework.orm.hibernate4.LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource);
		localSessionFactoryBean.setPackagesToScan(new String[] {"com.spittr.domain"});
		Properties properties=new Properties();
		properties.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
		localSessionFactoryBean.setHibernateProperties(properties);
		return localSessionFactoryBean;
	}
	
	//JPA应用程序管理类型EntityManagerFactoryBean
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalEntityManagerFactoryBean entityManagerFactoryBean=new LocalEntityManagerFactoryBean();
		entityManagerFactoryBean.setPersistenceUnitName("spitterPU");
		return entityManagerFactoryBean;
	}
	
	//JPA容器管理类型EntityManagerFactoryBean
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean2(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		
		return entityManagerFactoryBean;
	}
	
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter=new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(null);
		hibernateJpaVendorAdapter.setShowSql(true);
		return hibernateJpaVendorAdapter;
	}
	
	
	@Bean
	public MongoFactoryBean mongo() {
		MongoFactoryBean mongoFactoryBean=new MongoFactoryBean();
		mongoFactoryBean.setHost("localhost");
		return mongoFactoryBean;
	}
	
	@Bean
	public MongoOperations mongoTemplate(Mongo mongo) {
		return new MongoTemplate(mongo,"");
	}
	
	
	
	
}//会构建应用的Web层，创建展现Spittle的控制器以及处理用户注册成为Spitter的表单。
