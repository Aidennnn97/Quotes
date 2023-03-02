package org.example;


import org.example.quote.controller.QuoteController;
import org.example.quote.entity.Quote;
import org.example.system.controller.SystemController;

import java.util.*;

public class App {

    public void run() {
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController();
        QuoteController quoteController = new QuoteController();

        while(true){
            System.out.println("등록 / 목록 / 수정 / 삭제 / 종료");
            System.out.printf("명령) ");

            String command = Container.getScanner().nextLine().trim();
            Request request = new Request(command);

            switch (request.getActionCode()){
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
                    quoteController.delete(request);
//                    System.out.printf("actionCode: %s\n", request.getActionCode());
//                    System.out.printf("params.id: %s\n", request.getParam("id"));
//                    System.out.printf("params.writer: %s\n", request.getParam("writer"));
//                    System.out.printf("params.sentence: %s\n", request.getParam("sentence"));

                    break;
            }
        }
    }
}
