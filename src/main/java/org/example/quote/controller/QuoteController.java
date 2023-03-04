package org.example.quote.controller;
// 인포 데스크
// 고객응대, 허드렛일 같은 간단한 업무처리 해서 서비스쪽으로 넘김
// Controller : 본인이 맡은 주제와 관련된 고객의 요구사항을 듣고, 처리 후 응답
// 처리를 할 때, 본인이 판단하지 못하는 것은 서비스에 물어보는게 원칙
// 식당에서 점원의 역할이라고 보면 된다.
// 고객을 만나서, 그들의 요청을 받고 처리해준다.

import org.example.Container;
import org.example.Request;
import org.example.quote.entity.Quote;
import org.example.quote.service.QuoteService;

import java.util.List;


public class QuoteController {

    private final QuoteService quoteService;
    public QuoteController(){
        quoteService = new QuoteService();  // 서비스 객체
    }

    public void write() {
        // 예를 들어, 인포데스크에서 고객에게 처리할 간단한 업무들
        System.out.printf("명언 : ");
        String sentence = Container.getScanner().nextLine().trim();
        System.out.printf("작가 : ");
        String writer = Container.getScanner().nextLine().trim();

        int id = quoteService.write(writer, sentence);  // 서비스로 부터 id값을 넘겨받음

        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    public void list() {
        List<Quote> quotes = quoteService.findAll();    // 서비스에 데이터 요청

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
        List<Quote> quotes = quoteService.findAll();    // 서비스에 데이터 요청

        if(quotes.size() != 0){
            int id = request.getIntParam("id", -1);    // 정수화 하고 실패하면 -1 리턴
            if(id == -1){
                System.out.println("삭제?id=(정수)를 입력해 주세요.");
            } else{
                Quote quote = quoteService.findById(id); // 입력된 id와 일치하는 명언객체 찾기
                if(quote == null){
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
                } else {
                    quoteService.delete(quote); //찾은 명언객체를 리스트에서 제거요청
                    System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
                }
            }
        } else {
            System.out.println("삭제할 명언이 없습니다.");
        }
    }

    public void modify(Request request) {
        List<Quote> quotes = quoteService.findAll();    // 서비스에 데이터 요청

        if(quotes.size() != 0){
            int id = request.getIntParam("id", -1);    // 정수화 하고 실패하면 -1 리턴
            if(id == -1){
                System.out.println("수정?id=(정수)를 입력해 주세요.");
            } else{
                Quote quote = quoteService.findById(id); // 입력된 id와 일치하는 명언객체 찾기
                if(quote == null){
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
                } else{
                    System.out.printf("명언(기존): %s\n", quote.getSentence());
                    System.out.printf("명언(새로운): ");
                    String sentence = Container.getScanner().nextLine().trim();

                    System.out.printf("작가(기존): %s\n", quote.getWriter());
                    System.out.printf("작가(새로운): ");
                    String writer = Container.getScanner().nextLine().trim();

                    quoteService.modify(quote, sentence, writer);   // 수정 요청
                    System.out.printf("%d번 명언이 수정되었습니다.\n", id);
                }

            }
        } else {
            System.out.println("수정할 명언이 없습니다.");
        }
    }
}