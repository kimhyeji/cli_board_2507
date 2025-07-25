package com.ll.article;

import com.ll.Container;

import java.util.Map;

public class Article {
    private int id;
    private String subject;
    private String content;
    String author;
    String regDate;

    public Article(Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.subject = (String)row.get("subject");
        this.content = (String)row.get("content");
        this.author = (String)row.get("author");
        this.regDate = (String)row.get("regDate");
    }

    int getId() {
        return this.id;
    }

    String getSubject() {
        return this.subject;
    }

    String getContent() {
        return this.content;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
