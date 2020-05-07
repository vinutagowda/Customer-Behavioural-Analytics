package com.cts.cba.product;

import java.util.Collections;





import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class DemoApplication {

	

	public static void main(String[] args) {
		
	  
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {


		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.cts.cba"))
				.build().apiInfo(apiDetails());
	}

	public ApiInfo apiDetails() {
		return new ApiInfo("Customer Behaviour Analytics",
				"Enables analysing vivid customer purchase based on customer category. Generates a quantitative statistical report.",
				"1.0", "Free To Use", new Contact("Rishabh Nag", "http://localhost:9090/", "Rishabh.Nag@cognizant.com"),
				"API License", "http://localhost:9090/", Collections.emptyList());
	}
}
