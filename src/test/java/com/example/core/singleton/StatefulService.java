package com.example.core.singleton;

public class StatefulService {
    /*
    // 안티 singleton 패턴
    private int price; // 상태 유지 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price; // 여러 클라이언트가 singleton인 이 객체를 공유할 때 이 부분이 문제가 됨
    }

    public int getPrice(){
        return price;
    }

    */
    // stateless 패턴

    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        return price;
    }

}
