package com.second.spring_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                //사용할 패키지의 경로를 작성한다.
                //any는 다 사용한다는 뜻이다.
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
        //해당 swagger페이지의 정보?를 적는다.
        //new ApiInfo로 바로 작성할 수도 있다.

    }
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot Swagger App")
                //title은 화면에 보여질 제목이다.
                .description("Spring Study")
                //간단한 설명을 적는다.
                .version("1.0.0")
                //해당 api의 버전이다.
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