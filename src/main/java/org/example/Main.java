package org.example;

public class Main {
    public static void main(String[] args) {
        Container.init();   // 공통적으로 사용되는 것들을 모아두는 공간(Container) 초기화
        new App().run();
        Container.close();  // 공통적으로 사용되는 것들을 모아두는 공간(Container) 자원해제
    }
}
