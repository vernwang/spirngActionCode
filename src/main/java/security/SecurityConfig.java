package security;


import javax.sql.DataSource;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
		http.authorizeRequests().anyRequest().authenticated();
		
		
		http.authorizeRequests().antMatchers("/spitters/me").authenticated()
		.antMatchers(HttpMethod.POST, "/spittles").authenticated()
		.anyRequest().permitAll();
		
		
		http.authorizeRequests().antMatchers("/spitters/me").hasAuthority("ROLE_SPITTER");
		
		
		http.authorizeRequests().antMatchers("/spitters/me").access("hasRole('ROLE_SPITTER')");
		
		
		
		http.authorizeRequests().antMatchers("/spitters/me").authenticated()
		.antMatchers(HttpMethod.POST, "/spittles").authenticated()
		.anyRequest().permitAll().and().requiresChannel().antMatchers("/spitter/form").requiresSecure()
		.and().requiresChannel().antMatchers("/").requiresInsecure();
		
		http.formLogin().and().authorizeRequests().antMatchers("/spitters/me").authenticated();
		
		
		
		//formLogin()方法启用了基本的登录页功能
		
		http.formLogin().and().authorizeRequests().antMatchers("/spitter/me").hasRole("SPITER")
		.antMatchers(HttpMethod.POST,"/spittles").hasRole("SPITER")
		.anyRequest().permitAll()
		.and()
		.requiresChannel().antMatchers("spitter/form").requiresSecure()
		.and().httpBasic().realmName("Spitter");
		
		
		
		http.formLogin().loginPage("/login")
		.and().rememberMe().tokenValiditySeconds(2419200)
		.key("spiterKey")
		.and().logout().logoutSuccessUrl("/").logoutUrl("/signout");
		
		
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
		
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and()
		.withUser("admin").password("password").roles("USER","ADMIN");
		
		
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("").authoritiesByUsernameQuery("")
			.passwordEncoder(new StandardPasswordEncoder("53cr3t"));
		
		
		auth.ldapAuthentication().userSearchFilter("(uid={0})").groupSearchFilter("member={0}");
		
		
	}

	
	
	
	
	
	
	
	
	
	
}

