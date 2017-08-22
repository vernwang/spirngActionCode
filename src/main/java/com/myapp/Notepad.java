package com.myapp;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode=ScopedProxyMode.INTERFACES)
//proxyMode属性解决了将会话或请求作用域的bean注入到单例的问题。 interface代表这个代理实现了接口，并将调用委托给实现bean。
public class Notepad {
	
}
