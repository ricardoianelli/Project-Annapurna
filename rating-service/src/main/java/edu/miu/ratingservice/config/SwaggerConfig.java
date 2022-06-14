package edu.miu.ratingservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bijayshrestha on 6/13/22
 * @project cs544-project
 * @resource https://dzone.com/articles/spring-boot-micro-services-documentation-using-swa
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        Set<String> responseProduceType = new HashSet<String>();
        responseProduceType.add("application/json");
        responseProduceType.add("application/xml");
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(
                        RequestHandlerSelectors
                                .withClassAnnotation(RestController.class))
                .paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(false)
                .genericModelSubstitutes(ResponseEntity.class)
                .produces(responseProduceType)
                .consumes(responseProduceType)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        @SuppressWarnings("deprecation")
        ApiInfo apiInfo = new ApiInfo(
                "Rating Service REST API",
                "All Rating related information",
                "API",
                "Terms of services",
                "group5@miu.edu",
                "License of API",
                "API License URL");
        return apiInfo;
    }

    private Object apiKey() {
        // TODO Auto-generated method stub
        return null;
    }

}
