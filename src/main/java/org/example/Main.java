package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<quote> quotes = new ArrayList<>();    // 명언리스트
        int quoteNum = 0;
        System.out.println("== 명언 앱 ==");
        boolean run = true;
        while(run){
            System.out.println("등록 / 목록 / 수정 / 삭제 / 종료");
            System.out.printf("명령) ");
            String order = sc.nextLine().trim();
            switch (order){
                case "종료":
                    run = false;
                    break;
                case "등록":
                    int id = quoteNum + 1;
                    System.out.printf("명언 : ");
                    String sentence = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String writer = sc.nextLine().trim();
                    quotes.add(new quote(id, writer, sentence));    // quotes 리스트에 quote타입의 명언, 작가 저장
                    System.out.println(id + "번 명언이 등록되었습니다.");
                    quoteNum = id;
                    break;
                case "목록":
                    if(quotes.size() != 0){
                        System.out.println("번호 / 작가 / 명언");
                        System.out.println("-".repeat(30));
                        for(int i = quotes.size() - 1; i >= 0; i--){
                            quote quote = quotes.get(i);
                            System.out.println(quote.getId() + " / " + quote.getWriter() + " / " + quote.getSentence());
                        }
                    } else {
                        System.out.println("등록된 명언이 없습니다.");
                    }
                    break;
                case "삭제":
                    if(quotes.size() != 0){
                        System.out.printf("삭제할 명언번호 : ");
                        int num = sc.nextInt();
                        quotes.remove(num - 1);
                        System.out.println(num + "번 명언이 삭제되었습니다.");
                    } else {
                        System.out.println("삭제할 명언이 없습니다.");
                    }
                    break;
            }
        }
    }
}

class quote{
    private int id;
    private String sentence, writer;
    public quote(int id, String sentence, String writer) {
        this.id = id;
        this.sentence = sentence;
        this.writer = writer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }


}