package com.shaozhending.test.embedtomcat.init;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("com.shaozhending.embedtomcat")
public class WebAppConfig extends WebMvcConfigurerAdapter{

}
