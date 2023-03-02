package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 1;
        System.out.println("== 명언 앱 ==");
        boolean run = true;
        while(run){
            System.out.printf("명령) ");
            String order = sc.nextLine();
            switch (order){
                case "종료":
                    run = false;
                    break;
                case "등록" :
                    System.out.printf("명언 : ");
                    String quote = sc.nextLine();
                    System.out.printf("작가 : ");
                    String writer = sc.nextLine();
                    System.out.println(num + "번 명언이 등록되었습니다.");
                    break;
            }
        }
    }
}