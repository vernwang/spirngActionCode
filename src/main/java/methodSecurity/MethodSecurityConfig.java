package methodSecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled=true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration{

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		// TODO Auto-generated method stub
		DefaultMethodSecurityExpressionHandler expressionHandler=new DefaultMethodSecurityExpressionHandler();
		expressionHandler.setPermissionEvaluator(new SpittlePermissionEvaluator());
		
		
		return expressionHandler;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
		auth.inMemoryAuthentication().withUser("").password("").roles("USER");
	}
}
