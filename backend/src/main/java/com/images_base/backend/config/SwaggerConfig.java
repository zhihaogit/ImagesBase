package com.images_base.backend.config;

import com.images_base.backend.config.properties.ImagesBaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/23
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Autowired
    private ImagesBaseProperties imagesBaseProperties;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName(imagesBaseProperties.getSwaggerProperties().getGroupName())
                .enable(imagesBaseProperties.getSwaggerProperties().isEnable())
                .select()
                .apis(RequestHandlerSelectors.basePackage(imagesBaseProperties.getSwaggerProperties().getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(imagesBaseProperties.getSwaggerProperties().getTitle())
                .description(imagesBaseProperties.getSwaggerProperties().getDescription())
                .version(imagesBaseProperties.getSwaggerProperties().getVersion())
                .build();
    }
}
