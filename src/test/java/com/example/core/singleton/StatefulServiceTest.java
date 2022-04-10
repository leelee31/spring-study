package com.example.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {


    @Test
    void  statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(StatefulTestConfig.class);
        StatefulService bean = ac.getBean(StatefulService.class);
        StatefulService bean1 = ac.getBean(StatefulService.class);

        // 안티 singleton 패턴
//        bean.order("sumin", 10000);
//        bean1.order("minsu", 100);

//        int price = bean.getPrice();
//        System.out.println("price = " + price);

//        Assertions.assertEquals(100, bean.getPrice());

        int price = bean.order("sumin", 10000);
        int price2 = bean1.order("minsu", 100);
        System.out.println("price = " + price);

        Assertions.assertEquals(10000, price);
    }

    static class StatefulTestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}