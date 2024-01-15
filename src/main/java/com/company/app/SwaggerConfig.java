package com.company.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    public static final String CITY_TAG = "City Service";
    public static final String STATE_TAG = "State Service";
    public static final String COUNTRY_TAG = "Country Service";
    public static final String GENRE_TAG = "Genre Service";
    public static final String PERFORMER_TAG = "Performer Service";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                /*.tags(new Tag(CITY_TAG, "Service for managing cities"),
                        new Tag(STATE_TAG, "Service for managing states"),
                        new Tag(COUNTRY_TAG, "Service for managing countries"),
                        new Tag(GENRE_TAG, "Service for managing genres"),
                        new Tag(PERFORMER_TAG, "Service for managing performers"))*/;
    }
}
