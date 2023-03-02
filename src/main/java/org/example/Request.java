package org.example;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String actionCode;
    private Map<String, String> params;
    public Request(String command) {
        String[] commandBits = command.split("\\?", 2); // ?기준으로 쵀대 2개까지 나눈다 => 삭제?id=1&writer=22 -> [삭제, id=1&writer=22]

        actionCode = commandBits[0]; // 명령 키워드(commandBits[0]) actionCode에 저장

        params = new HashMap<>();   // id=1&writer=22 를 key, value 타입의 Map으로 저장할 공간 {"id":"1", "writer":"22"} 처럼

        String[] paramBits = commandBits[1].split("&");  // & 기준으로 나눔 => [id=1, writer=22]

        for(String paramStr : paramBits){
            String[] paramStrBits = paramStr.split("=", 3); // & 기준으로 나눈 id=1 과 writer=22를 다시 = 기준으로 나눈다 => [id, 1] [writer, 22]

            String key = paramStrBits[0];   // [id, 1] 의 id, [writer, 22]의 writer
            String value = paramStrBits[1]; // [id, 1] 의 1, [writer, 22]의 22

            params.put(key, value); // key와 value를 Map타입의 params에 저장
        }
    }

    public String getParam(String key){
        return params.get(key);
    }

    public String getActionCode() {
        return actionCode;
    }

}
