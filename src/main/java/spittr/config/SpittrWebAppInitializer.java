package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.Registration;
import javax.servlet.ServletRegistration;


/*
 * 我们需要知道扩展了AbstractAnnotationConfigDispatcherServletInitializer的任意类都会自动配置Dispatcher-servlet
 * 和Spring应用上下文，Spring应用上下文会位于servlet上下文中。
 * 
 * 原因：
 * 在Spring3.0中，容器会在类路径中查找实现ServletContainerInitializer接口的类，如果能发现的话，就用它来配置Servlet容器。
 * 
 * 当DispatcherServlet启动时，他会创建Spring应用上下文，并加载配置文件。
 * 
 * 但是在Spring Web应用中，通常还会有另一个应用上下文。 另外的这个应用上下文是由contextLoaderListener创建的。
 * 
 * AbstractAnnotationConfigDispatcherServletInitializer同时创建了 DispatcherServlet和ContextLoaderListener。
 * getServletConfig返回带有@Configuration注解的类将会定义DispatcherServlet应用上下文中的bean。
 * getRootConfig，返回带有@Configuration注解的类将会用来配置ContextLoadListener创建的应用上下文的bean.
 */
public class SpittrWebAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return  new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}


    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
        registration.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads", 2097152, 4194304, 0));
    }

	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		
		return new Filter[] {new MyFilter()};
	}
    
	
	
	
    
}
