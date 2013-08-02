package com.shaozhending.test.embedtomcat;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.SpringServletContainerInitializer;

import com.shaozhending.test.embedtomcat.init.WebAppInitializer;

public class JavaInitializerTomcat extends Tomcat{
	
	@Override
	public void start() throws LifecycleException{
		File base = new File(System.getProperty("java.io.tmpdir"));
		Context rootCtx = this.addContext("", base.getAbsolutePath());
		Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
		classes.add(WebAppInitializer.class);
		
		// Scan the web app initializer
		rootCtx.addServletContainerInitializer(new SpringServletContainerInitializer(), classes);
		super.start();
	}
}
