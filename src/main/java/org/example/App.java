package org.example;


import org.example.quote.controller.QuoteController;
import org.example.quote.entity.Quote;
import org.example.system.controller.SystemController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController();
        QuoteController quoteController = new QuoteController(sc);

        while(true){
            System.out.println("등록 / 목록 / 수정 / 삭제 / 종료");
            System.out.printf("명령) ");
            String order = sc.nextLine().trim();
            switch (order){
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    quoteController.write();
                    break;
                case "목록":
                    quoteController.list();
                    break;
                case "삭제":
                    quoteController.delete();
                    break;
            }
        }
    }
}
