package org.example;
// 라우팅
// 은행가면 제일 처음에 어떤 업무로 왔는지 물어보는 역할
//App : 라우팅, 고객이 올바른 컨트롤러를 만나도록 교통정리


import org.example.quote.controller.QuoteController;
import org.example.system.controller.SystemController;

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
                case "수정":
                    quoteController.modify(request);
            }
        }
    }
}
