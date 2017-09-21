package WebSocket.marcopolo;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletRegistration;

public class WebInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer{


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebSocketConfig.class,WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
        registration.setAsyncSupported(true);
    }
}
