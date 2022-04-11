package com.example.core.singleton;

public class SingletonServiceTest {

    // static 선언하면 자기 자신이 클래스 레벨에 올라가기 때문에 딱 하나만 존재하게 됨
    public static final SingletonServiceTest singletonInstance = new SingletonServiceTest();

    // 생성자를 private으로 만들면 외부에서 생성자 호출 불가
    private SingletonServiceTest() {

    }

    // 얘를 통해서만 객체를 조회할 수 있음
    public static SingletonServiceTest getInstance() {
        return singletonInstance;
    }
}
