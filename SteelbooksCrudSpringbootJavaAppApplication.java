package com.steelbooks.crudapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@SpringBootApplication
public class SteelbooksCrudSpringbootJavaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SteelbooksCrudSpringbootJavaAppApplication.class, args);
		
	
	}



}
