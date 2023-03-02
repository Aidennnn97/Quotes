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
            switch (command){
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    quoteController.write();
                    break;
                case "목록":
                    quoteController.list();
                    break;
                case "삭제?id=1&writer=22":
//                    Request request = new Request(command);
//                    quoteController.delete();
                    String[] commandBits = command.split("\\?", 2); // ?기준으로 쵀대 2개까지 나눈다 => 삭제?id=1&writer=22 -> [삭제, id=1&writer=22]
                    String actionCode = commandBits[0]; // 명령 키워드(commandBits[0]) actionCode에 저장

                    Map<String, String> params = new HashMap<>();   // id=1&writer=22 를 key, value 타입의 Map으로 저장할 공간 {"id":"1", "writer":"22"} 처럼

                    String[] paramBits = commandBits[1].split("&");  // & 기준으로 나눔 => [id=1, writer=22]
                    for(String paramStr : paramBits){
                        String[] paramStrBits = paramStr.split("=", 2); // & 기준으로 나눈 id=1 과 writer=22를 다시 = 기준으로 나눈다 => [id, 1] [writer, 22]

                        String key = paramStrBits[0];   // [id, 1] 의 id, [writer, 22]의 writer
                        String value = paramStrBits[1]; // [id, 1] 의 1, [writer, 22]의 22

                        params.put(key, value); // key와 value를 Map타입의 params에 저장
                    }

                    System.out.printf("actionCode: %s\n", actionCode);
                    System.out.printf("params: %s\n", params);

                    break;
            }
        }
    }
}
