package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Venkatesh
 *
 */
/**
 * @author Venkatesh
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Config implements WebMvcConfigurer{

	
	/**
	 * @return Docket
	 */
	@Bean
	public Docket api() {
		 return new Docket(DocumentationType.SWAGGER_2).
				 select()
		            .apis(RequestHandlerSelectors
		         .any())
		            .paths(PathSelectors.any())
		            .build().apiInfo(apiEndPointsInfo());
	}
	
	  private ApiInfo apiEndPointsInfo() {
	        return new ApiInfoBuilder().title("Spring Boot REST API")
	            .description("Invokes walmart remote api to get list of products")
	            .version("1.0.0")
	            .build();
	    }
	  
	  @Override
		 public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry.addResourceHandler("swagger-ui.html")
		        .addResourceLocations("classpath:/META-INF/resources/");
		 registry.addResourceHandler("/webjars/**")
		        .addResourceLocations("classpath:/META-INF/resources/webjars/");
		 }
}
