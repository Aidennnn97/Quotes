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

        if(commandBits.length == 1){    // 명령어가 등록, 목록, 종료 처럼 뒤에 ?값이 없으면 리턴
            return;
        }

        try{
            String[] paramBits = commandBits[1].split("&");  // & 기준으로 나눔 => [id=1, writer=22]

            for(String paramStr : paramBits){
                String[] paramStrBits = paramStr.split("=", 3); // & 기준으로 나눈 id=1 과 writer=22를 다시 = 기준으로 나눈다 => [id, 1] [writer, 22]

                String key = paramStrBits[0];   // [id, 1] 의 id, [writer, 22]의 writer
                String value = paramStrBits[1]; // [id, 1] 의 1, [writer, 22]의 22

                params.put(key, value); // key와 value를 Map타입의 params에 저장
            }
        } catch (ArrayIndexOutOfBoundsException e){
        }

    }

    public String getParam(String key){
        return params.get(key);
    }

    public String getActionCode() {
        return actionCode;
    }

    public int getIntParam(String key, int defaultValue) {
        try{
           return Integer.parseInt(getParam(key));  // 문자열로 넘어오기 때문에 수동 형변환을 해줘야 한다턴
        } catch (NumberFormatException e){
            return defaultValue;
        }
    }

}
