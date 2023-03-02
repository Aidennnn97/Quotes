package org.example.quote.controller;

import org.example.Container;
import org.example.Request;
import org.example.quote.entity.Quote;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuoteController {
    private final List<Quote> quotes;    // 명언리스트
    private int quoteNum;   // 명언 번호
    public QuoteController(){
        quotes = new ArrayList<>();    // 명언리스트
        quoteNum = 0;
    }

    private Quote findById(int id){
        for(Quote quote : quotes){  // quotes 리스트를 돌면서 입력된 id와 동일한 id값을 가진 quote를 찾음
            if(quote.getId() == id){
                return quote;
            }
        }
        return null;
    }

    public void write() {
        int id = quoteNum + 1;
        System.out.printf("명언 : ");
        String sentence = Container.getScanner().nextLine().trim();
        System.out.printf("작가 : ");
        String writer = Container.getScanner().nextLine().trim();
        quotes.add(new Quote(id, writer, sentence));    // quotes 리스트에 quote타입의 명언, 작가 저장
        System.out.println(id + "번 명언이 등록되었습니다.");
        quoteNum = id;
    }

    public void list() {
        if(quotes.size() != 0){
            System.out.println("번호 / 작가 / 명언");
            System.out.println("-".repeat(30));
            for(int i = quotes.size() - 1; i >= 0; i--){
                Quote quote = quotes.get(i);
                System.out.println(quote.getId() + " / " + quote.getWriter() + " / " + quote.getSentence());
            }
        } else {
            System.out.println("등록된 명언이 없습니다.");
        }
    }

    public void delete(Request request) {
        if(quotes.size() != 0){
            int id = request.getIntParam("id", -1);    // 정수화 하고 실패하면 -1 리턴
            if(id == -1){
                System.out.println("id(정수)를 입력해 주세요.");
            } else{
                Quote quote = findById(id); // 입력된 id와 일치하는 명언객체 찾기
                if(quote == null){
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
                } else {
                    quotes.remove(quote);   // 찾은 명언객체를 리스트에서 제거
                    System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
                }
            }
        } else {
            System.out.println("삭제할 명언이 없습니다.");
        }
    }

    public void modify(Request request) {
        if(quotes.size() != 0){
            int id = request.getIntParam("id", -1);    // 정수화 하고 실패하면 -1 리턴
            if(id == -1){
                System.out.println("id(정수)를 입력해 주세요.");
            } else{
                Quote quote = findById(id); // 입력된 id와 일치하는 명언객체 찾기
                if(quote == null){
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
                } else{
                    System.out.printf("명언(기존): %s\n", quote.getSentence());
                    System.out.printf("명언(새로운): ");
                    String sentence = Container.getScanner().nextLine().trim();

                    System.out.printf("작가(기존): %s\n", quote.getWriter());
                    System.out.printf("작가(새로운): ");
                    String writer = Container.getScanner().nextLine().trim();

                    quote.setSentence(sentence);
                    quote.setWriter(writer);
                    System.out.printf("%d번 명언이 수정되었습니다.\n", id);
                }

            }
        } else {
            System.out.println("수정할 명언이 없습니다.");
        }
    }
}