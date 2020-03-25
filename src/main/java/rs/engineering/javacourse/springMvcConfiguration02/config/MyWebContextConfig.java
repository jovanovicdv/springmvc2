package rs.engineering.javacourse.springMvcConfiguration02.config;
//konfigurisanje binova u web kontekstu za konkretni dispatcher


import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import rs.engineering.javacourse.springMvcConfiguration02.controller.CompanyController;
import rs.engineering.javacourse.springMvcConfiguration02.controller.HomeController;
import rs.engineering.javacourse.springMvcConfiguration02.controller.UserController;


@Configuration
@EnableWebMvc
public class MyWebContextConfig {
	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
	//configure handler mapper
	@Bean
	public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
		SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
		
		Map<String, Object> urlMap = new HashMap<String, Object>();
		urlMap.put("/home", homeController());
		urlMap.put("/home/simpleurl", homeController());
		simpleUrlHandlerMapping.setUrlMap(urlMap);
		return simpleUrlHandlerMapping;
	}
	
	@Bean
	BeanNameUrlHandlerMapping beanNameUrlHandlerMapping() {
		return new BeanNameUrlHandlerMapping();
	}
	//configure handler mapping
	@Bean
	public UserController userController() {
		return new UserController();
	}
	@Bean
	public CompanyController companyController() {
		return new CompanyController();
	}
	
//	@Bean
//	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
//		return new RequestMappingHandlerMapping();
//	} ovo treba samo ako ne stavimo @EnableMvc
	
	//configure ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
