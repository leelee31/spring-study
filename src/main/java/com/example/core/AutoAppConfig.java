package com.example.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 기존에 작성한 beanfactory를 이용한 빈 수동 등록 코드를 남기기 위해
)
public class AutoAppConfig {
}
