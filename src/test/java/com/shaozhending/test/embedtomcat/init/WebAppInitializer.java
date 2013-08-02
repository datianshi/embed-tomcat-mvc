package com.shaozhending.test.embedtomcat.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		//Config listener root context matching in web.xml
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);
		ContextLoaderListener listner = new ContextLoaderListener(rootContext);
		
		//Register spring servlet context
		AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
		webAppContext.register(WebAppConfig.class);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webAppContext);
		//Matche the servlet name in web.xml
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("appServlet", dispatcherServlet);
		dispatcher.addMapping("/");
	}

}
