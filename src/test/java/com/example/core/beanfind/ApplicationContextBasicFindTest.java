package com.example.core.beanfind;

import com.example.core.AppConfig;
import com.example.core.member.MemberService;
import com.example.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName () {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertInstanceOf(MemberService.class, memberService);
    }

    @Test
    @DisplayName("빈 타입으로 조회")
    void findBeanByType () {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertInstanceOf(MemberService.class, memberService);
    }

    // 구체 타입으로 조회는 가능하지만 역할에 의존하는 것이 기본 원칙이다
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2 () {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNotExistName () {
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("lalala", MemberService.class));
    }

}
