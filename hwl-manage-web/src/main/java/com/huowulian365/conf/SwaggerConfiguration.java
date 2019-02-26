package com.huowulian365.conf;


import com.google.common.base.Predicates;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Date;

import static com.google.common.collect.Lists.newArrayList;


@Configuration
@ConditionalOnClass(Docket.class)
public class SwaggerConfiguration {


    @Bean
    @ConditionalOnMissingBean(Docket.class)
    public Docket petApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .pathMapping("/")
                .directModelSubstitute(Date.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .securitySchemes(newArrayList(jwtApiKey())) // 为swagger指定鉴权方式
                .globalResponseMessage(RequestMethod.GET,
                        newArrayList(new ResponseMessageBuilder()
                                .code(500)
                                .message("500 message")
                                .responseModel(new ModelRef("Error"))
                                .build()));
    }

//    配置默认的鉴权账号信息
//    @Bean
//    @ConditionalOnClass(springfox.documentation.swagger.web.ApiKeyVehicle.class) // required springfox 2.4.0
//    public SecurityConfiguration securityConfiguration(){
//        SecurityConfiguration securityConfiguration = null;
//
//        return new SecurityConfiguration(
//                null,
//                null,
//                null,
//                null,
//                null,
//                ApiKeyVehicle.HEADER,
//                apiDocProperties.getKeyName(),
//                ",");
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Api Documentation")
                .description("Api Documentation")
                .contact(new Contact("李雪洋",
                        "http://www.huowulian365.com",
                        "951773148@qq.com")) // required springfox 2.4.0 begin
                .version("1.0")
                .termsOfServiceUrl("urn:tos")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

    private ApiKey jwtApiKey() {
        //return null;
        return new ApiKey("jwt", "Authorization", "header");
    }

}
