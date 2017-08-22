package spittr.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

/*
 * 注册一个servlet
 */
public class MyServletInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		
		javax.servlet.ServletRegistration.Dynamic myServlet=servletContext.addServlet("myServlet",MyServlet.class);
		
		myServlet.addMapping("/custom/**");
		
		Dynamic filter=servletContext.addFilter("myFilter", MyFilter.class);
		
		filter.addMappingForUrlPatterns(null, false, "/custom/*");
		
		
		DispatcherServlet dispatcherServlet=new DispatcherServlet();
		myServlet=servletContext.addServlet("appServlet", dispatcherServlet);
		
		myServlet.addMapping("/");
		myServlet.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads"));
		
		
	}
	
	
}
