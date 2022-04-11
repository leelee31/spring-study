package com.example.core.beanfind;

import com.example.core.AppConfig;
import com.example.core.member.MemberRepository;
import com.example.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(FooBeanConfig.class);

    // NoUniqueBeanDefinitionException
    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 중복 오류 발생")
    void findBeanByTypeDuplicate () {
        MemberRepository bean = ac.getBean(MemberRepository.class);
        System.out.println("bean = " + bean);
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 중복 오류 발생")
    void findBeanByTypeDuplicateThrows () {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("bean 이름 부여해서 조회")
    void findBeanByNameDuplicate () {
        MemberRepository bean = ac.getBean("fi", MemberRepository.class);
        Assertions.assertInstanceOf(MemberRepository.class, bean);
    }

    @Test
    @DisplayName("특정 타입 모두 조회")
    void findAllBeanByType () {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("s = " + s + " value = " + beansOfType.get(s));
        }
    }

    // class 내부에서만 사용 (scope 제한)
    @Configuration
    static  class FooBeanConfig {
        @Bean("fi")
        public MemberRepository memberRepository1 () {
            return new MemoryMemberRepository();
        }

        @Bean("se")
        public MemberRepository memberRepository2 () {
            return new MemoryMemberRepository();
        }
    }
}
