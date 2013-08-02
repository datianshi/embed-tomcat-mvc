package com.shaozhending.test.embedtomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class IntegrationTest {
	
	@Autowired
	RestTemplate restTemplate;
	
	Tomcat tomcat = new JavaInitializerTomcat();
	
	@Before
	public void setUp() throws LifecycleException{
		tomcat.start();
	}
	
	@Test
	public void test() throws InterruptedException{
		Assert.assertEquals("Hello World",restTemplate.getForObject("http://localhost:8080/hello", String.class));
	}
	
	@After
	public void tearDown() throws LifecycleException{
		tomcat.stop();
	}
	
	
}
