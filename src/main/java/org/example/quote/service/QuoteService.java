package org.example.quote.service;

import org.example.quote.entity.Quote;
import org.example.quote.repository.QuoteRepository;

import java.util.List;

// 회사 과장
// 핵심로직, 중요 데이터 처리
// Service : 핵심로직을 담당한다.
// 서비스는 오직 컨트롤러의 요청에 의해서만 일을 한다.
// 식당에서 메인 요리사의 역할이라고 보면 된다.
public class QuoteService {
    private final QuoteRepository quoteRepository;
    public QuoteService() {
        quoteRepository = new QuoteRepository();
    }
    public List<Quote> findAll() {
        return quoteRepository.findAll();
    }
    public Quote findById(int id) {
        return quoteRepository.findById(id);
    }
    public int write(String writer, String sentence) {
        return quoteRepository.write(writer, sentence);
    }
    public void delete(Quote quote) {
        quoteRepository.remove(quote);
    }
    public void modify(Quote quote, String sentence, String writer) {
        quoteRepository.modify(quote, sentence, writer);
    }
}
