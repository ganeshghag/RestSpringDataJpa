package com.ghag.rnd.rest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/*
 * 
 * 
 * swagger and swagger ui integration into spring boot as per
 * http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
 * works just fine without annotations etc
 * 
 */


@Configuration
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@ComponentScan  //important and required
@EnableSwagger2
public class Application {

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());
    }
	
	private ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo(
	      "REST Spring Data Sample REST API",
	      "Swagger doc generated for Spring Data JPA REST APIs",
	      "API TOS",
	      "Terms of service",
	      "ganesh.ghag@gmail.com",
	      "License of API",
	      "http://ganeshghag.blogspot.in");
	    return apiInfo;
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}