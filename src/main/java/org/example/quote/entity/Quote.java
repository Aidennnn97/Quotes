package org.example.quote.entity;

public class Quote {
    private int id;
    private String sentence, writer;
    public Quote(int id, String sentence, String writer) {
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
