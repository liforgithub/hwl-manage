package com.huowulian365;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "com.huowulian365.mapper")
@EnableSwagger2
public class HwlApplication {

    public static void main(String[] args) {
        SpringApplication.run(HwlApplication.class, args);
    }
}
