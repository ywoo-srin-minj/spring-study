package com.second.spring_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
    private ApiInfo SwaggerApiInfo(){
        Contact contact = new Contact("SpringStudy", "https://github.com/ywoo-srin-minj/spring_study", "");

        return new ApiInfoBuilder()
                .title("Spring Study API")
                .description("Spring Study")
                .version("1.0")
                .contact(contact)
                .build();
    }

    @Bean
    public Docket SwaggerApi(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("Study API")
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.second.spring_study.controller"))
                .build()
                .apiInfo(SwaggerApiInfo());
    }
}
