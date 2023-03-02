package org.example.quote.controller;

import org.example.quote.entity.Quote;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuoteController {
    private final Scanner sc;
    private final List<Quote> quotes;    // 명언리스트
    private int quoteNum;   // 명언 번호
    public QuoteController(Scanner sc){
        this.sc = sc;
        quotes = new ArrayList<>();    // 명언리스트
        quoteNum = 0;
    }
    public void write() {
        int id = quoteNum + 1;
        System.out.printf("명언 : ");
        String sentence = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String writer = sc.nextLine().trim();
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

    public void delete() {
        if(quotes.size() != 0){
            System.out.printf("삭제할 명언번호 : ");
            int num = sc.nextInt();
            if(quotes.get(num - 1).equals(null)){
                System.out.println(num + "번 명언은 존재하지 않습니다.");
            } else{
                quotes.remove(num - 1);
                System.out.println(num + "번 명언이 삭제되었습니다.");
            }
        } else {
            System.out.println("삭제할 명언이 없습니다.");
        }
    }
}
