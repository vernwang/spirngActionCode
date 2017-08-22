//package com.myapp;
//
//import javax.activation.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Conditional;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//@Configuration
//public class DataSourceConfig {
//
//	@Bean(destroyMethod="shutdown")
//	@Profile("dev")
//	public void embeddedDataSource() {
//
//	}
//
//	@Bean
//	@Profile("prod")
//	public void e1mbeddedDataSource() {
//
//	}
//
//	@Bean
//	@Conditional(MagicExistsCondition.class)
//	public void magincBean() {
//
//	}
//
//
//	@Autowired
//	@Qualifier("iceCream")
//	public void setDessert(Dessert dessert) {
//
//	}
//
//
//
//
//}
