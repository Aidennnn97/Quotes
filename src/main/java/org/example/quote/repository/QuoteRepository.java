package org.example.quote.repository;

import org.example.quote.entity.Quote;

import java.util.ArrayList;
import java.util.List;

// Repository : 데이터의 저장/조회를 담당한다.
// 리포지터리는 오직 서비스의 요청에 의해서만 일을 한다.
// 식당에서 재료담당 요리사의 역할이라고 보면 된다.
public class QuoteRepository {
    private final List<Quote> quotes;    // 명언리스트
    private int quoteNum;   // 명언 번호

    public QuoteRepository() {
        quotes = new ArrayList<>();    // 명언리스트
        quoteNum = 0;
    }

    public List<Quote> findAll() {
        return quotes;
    }

    public Quote findById(int id){
        for(Quote quote : quotes){  // quotes 리스트를 돌면서 입력된 id와 동일한 id값을 가진 quote를 찾음
            if(quote.getId() == id){
                return quote;
            }
        }
        return null;
    }

    public int write(String writer, String sentence) {
        int id = quoteNum + 1;

        quotes.add(new Quote(id, writer, sentence));    // quotes 리스트에 quote타입의 명언, 작가 저장

        quoteNum = id;

        return id;
    }

    public void remove(Quote quote) {
        quotes.remove(quote);   // 컨트롤러로부터 받은 id에 맞는 데이터 삭제
    }

    public void modify(Quote quote, String sentence, String writer) {
        quote.setSentence(sentence);
        quote.setWriter(writer);
    }
}
